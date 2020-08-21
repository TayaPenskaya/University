'use strict';

/**
 * Флаг решения дополнительной задачи
 * @see README.md
 */
const isExtraTaskSolved = false;
const possibleDays = ['ПН', 'ВТ', 'СР'];
const MIN_HR = 60;
const MIN_DAY = 24 * MIN_HR;
const minOfDays = new Map();
let exists = false;

function init() {
  possibleDays.forEach(day => {
    minOfDays.set(day, Array(MIN_DAY).fill(false));
  });
}

function getBankZone(str) {
  return parseInt(str.split('+')[1]);
}

function getParametersOfDay(str) {
  const parameters = str.split(/\s|\+|:/);
  const day = parameters[0];
  const hr = parseInt(parameters[1]);
  const min = parseInt(parameters[2]);
  const zone = parseInt(parameters[3]);

  return { day, hr, min, zone };
}

function getTimeInMinutes(time, bankZone) {
  return time.hr * MIN_HR + time.min + (bankZone - time.zone) * MIN_HR;
}

function formatTime(time) {
  if (Math.floor(time / 10) === 0) {
    return '0' + time;
  }

  return time;
}

function analyzeBankSchedule(workingHours, bankZone) {
  possibleDays.forEach(day => {
    const from = getParametersOfDay(`${day} ${workingHours.from}`);
    const to = getParametersOfDay(`${day} ${workingHours.to}`);
    const minOfDay = minOfDays.get(day);
    for (let i = getTimeInMinutes(from, bankZone); i < getTimeInMinutes(to, bankZone); ++i) {
      minOfDay[i] = true;
    }
    minOfDays.set(day, minOfDay);
  });
}

function analyzeGangSchedule(schedule, bankZone) {
  Object.values(schedule).forEach(gangster => {
    gangster.forEach(time => {
      const from = getParametersOfDay(time.from);
      const to = getParametersOfDay(time.to);
      const fromMin = getTimeInMinutes(from, bankZone);
      const toMin = getTimeInMinutes(to, bankZone);
      if (from.day === to.day) {
        const minOfDay = minOfDays.get(from.day);
        for (let i = fromMin; i < toMin; ++i) {
          minOfDay[i] = false;
        }
        minOfDays.set(from.day, minOfDay);
      } else {
        const firstDay = minOfDays.get(from.day);
        for (let i = fromMin; i < MIN_DAY; ++i) {
          firstDay[i] = false;
        }
        minOfDays.set(from.day, firstDay);
        const secondDay = minOfDays.get(to.day);
        for (let i = 0; i < toMin; ++i) {
          secondDay[i] = false;
        }
        minOfDays.set(to.day, secondDay);
      }
    });
  });
}

function tryToFindTime(duration) {
  for (let i = 0; i < possibleDays.length; ++i) {
    let long = 0;
    let startTime = -1;
    const day = possibleDays[i];
    const minOfDay = minOfDays.get(day);
    for (let j = 0; j < minOfDay.length; ++j) {
      if (minOfDay[j]) {
        if (startTime === -1) {
          startTime = j;
        }
        long++;
      }
      if (minOfDay[j] === false) {
        long = 0;
        startTime = -1;
      }
      if (long === duration) {
        exists = true;

        return { day: day, time: startTime };
      }
    }
  }
}

/**
 * @param {Object} schedule Расписание Банды
 * @param {number} duration Время на ограбление в минутах
 * @param {Object} workingHours Время работы банка
 * @param {string} workingHours.from Время открытия, например, "10:00+5"
 * @param {string} workingHours.to Время закрытия, например, "18:00+5"
 * @returns {Object}
 */
function getAppropriateMoment(schedule, duration, workingHours) {
  init();
  const bankZone = getBankZone(workingHours.from);
  analyzeBankSchedule(workingHours, bankZone);
  analyzeGangSchedule(schedule, bankZone);

  const start = tryToFindTime(duration);

  return {
    /**
     * Найдено ли время
     * @returns {boolean}
     */
    exists() {
      return exists;
    },

    /**
     * Возвращает отформатированную строку с часами
     * для ограбления во временной зоне банка
     *
     * @param {string} template
     * @returns {string}
     *
     * @example
     * ```js
     * getAppropriateMoment(...).format('Начинаем в %HH:%MM (%DD)') // => Начинаем в 14:59 (СР)
     * ```
     */
    format(template) {
      if (!exists) {
        return '';
      }

      return template
        .replace('%HH', formatTime(Math.floor(start.time / MIN_HR)))
        .replace('%MM', formatTime(start.time % MIN_HR))
        .replace('%DD', start.day);
    },

    /**
     * Попробовать найти часы для ограбления позже [*]
     * @note Не забудь при реализации выставить флаг `isExtraTaskSolved`
     * @returns {boolean}
     */
    tryLater() {
      return false;
    }
  };
}

module.exports = {
  getAppropriateMoment,

  isExtraTaskSolved
};
