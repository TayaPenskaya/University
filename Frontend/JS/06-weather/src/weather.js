'use strict';

global.fetch = require('node-fetch');

function categorizeWeather(condition) {
  if (condition === 'clear' || condition === 'partly-cloudy') {
    return 'sunny';
  } else if (condition === 'cloudy' || condition === 'overcast') {
    return 'cloudy';
  }

  return 'unsuitable conditions';
}

function getWeather(geoid) {
  const url = `https://api.weather.yandex.ru/v1/forecast?hours=false&limit=7&geoid=${geoid}`;

  return global
    .fetch(url)
    .then(response => response.json())
    .then(data => ({
      geoid: geoid,
      forecasts: data['forecasts'].map(day =>
        categorizeWeather(day['parts']['day_short']['condition'])
      )
    }))
    .catch(() => {
      throw new Error(`Can't get the weather of this ${geoid} location.`);
    });
}

/**
 * @typedef {object} TripItem Город, который является частью маршрута.
 * @property {number} geoid Идентификатор города
 * @property {number} day Порядковое число дня маршрута
 */

class TripBuilder {
  constructor(geoid) {
    this.geoid = geoid;
    this.weatherOfDays = [];
    this.maxDays = Infinity;
  }
  /**
   * Метод, добавляющий условие наличия в маршруте
   * указанного количества солнечных дней
   * Согласно API Яндекс.Погоды, к солнечным дням
   * можно приравнять следующие значения `condition`:
   * * `clear`;
   * * `partly-cloudy`.
   * @param {number} daysCount количество дней
   * @returns {object} Объект планировщика маршрута
   */
  sunny(daysCount) {
    for (let i = 0; i < daysCount; ++i) {
      this.weatherOfDays.push('sunny');
    }

    return this;
  }

  /**
   * Метод, добавляющий условие наличия в маршруте
   * указанного количества пасмурных дней
   * Согласно API Яндекс.Погоды, к солнечным дням
   * можно приравнять следующие значения `condition`:
   * * `cloudy`;
   * * `overcast`.
   * @param {number} daysCount количество дней
   * @returns {object} Объект планировщика маршрута
   */
  cloudy(daysCount) {
    for (let i = 0; i < daysCount; ++i) {
      this.weatherOfDays.push('cloudy');
    }

    return this;
  }

  /**
   * Метод, добавляющий условие максимального количества дней.
   * @param {number} daysCount количество дней
   * @returns {object} Объект планировщика маршрута
   */
  max(daysCount) {
    this.maxDays = daysCount;

    return this;
  }

  /**
   * Метод, возвращающий Promise с планируемым маршрутом.
   * @returns {Promise<TripItem[]>} Список городов маршрута
   */
  async build() {
    return Promise.all(this.geoid.map(getWeather)).then(cities => {
      if (this.weatherOfDays.length > 7) {
        throw new Error('Не могу построить маршрут!');
      }

      const path = [];
      const visited = new Set();
      let currentDay = 0;
      let findOneCity = true;

      while (currentDay < this.weatherOfDays.length && findOneCity) {
        findOneCity = false;
        cities.forEach(city => {
          if (!visited.has(city.geoid)) {
            for (let i = 0; i < this.maxDays; ++i) {
              if (
                city.forecasts[currentDay] === this.weatherOfDays[currentDay] &&
                currentDay < this.weatherOfDays.length
              ) {
                findOneCity = true;
                visited.add(city.geoid);
                currentDay++;
                path.push({ geoid: city.geoid, day: currentDay });
              } else {
                break;
              }
            }
          }
        });
      }

      if (path.length !== this.weatherOfDays.length) {
        throw new Error('Не могу построить маршрут!');
      }

      return path;
    });
  }
}

/**
 * Фабрика для получения планировщика маршрута.
 * Принимает на вход список идентификаторов городов, а
 * возвращает планировщик маршрута по данным городам.
 *
 * @param {number[]} geoids Список идентификаторов городов
 * @returns {TripBuilder} Объект планировщика маршрута
 * @see https://yandex.ru/dev/xml/doc/dg/reference/regions-docpage/
 */
function planTrip(geoids) {
  return new TripBuilder(geoids);
}

module.exports = {
  planTrip
};
