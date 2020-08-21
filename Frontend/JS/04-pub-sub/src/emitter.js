'use strict';

/**
 * Сделано дополнительное задание: реализованы методы several и through.
 */
const isExtraTaskSolved = true;

/**
 * Получение нового Emitter'а
 * @returns {Object}
 */
function getEmitter() {
  const events = new Map();

  return {
    /**
     * Подписка на событие
     * @param {string} event
     * @param {Object} context
     * @param {Function} handler
     */
    on: function(event, context, handler) {
      if (!events.has(event)) {
        events.set(event, []);
      }
      events.get(event).push({ context, handler, type: 'on' });

      return this;
    },

    /**
     * Отписка от события
     * @param {string} event
     * @param {Object} context
     */
    off: function(event, context) {
      for (const e of events.keys()) {
        if (e === event || e.startsWith(`${event}.`)) {
          events.set(e, events.get(e).filter(i => i.context !== context));
        }
      }

      return this;
    },

    /**
     * Уведомление о событии
     * @param {string} event
     */
    emit: function(event) {
      while (event.length !== 0) {
        if (events.has(event)) {
          for (const e of events.get(event)) {
            switch (e.type) {
              case 'on':
                e.handler.call(e.context);
                break;
              case 'several':
                if (e.counter < e.num) {
                  e.handler.call(e.context);
                }
                break;
              case 'through':
                if (e.counter % e.num === 0) {
                  e.handler.call(e.context);
                }
                break;
            }
            e.counter++;
          }
        }
        event = event.substr(0, event.lastIndexOf('.'));
      }

      return this;
    },

    /**
     * Подписка на событие с ограничением по количеству отправляемых уведомлений
     * @param {string} event
     * @param {Object} context
     * @param {Function} handler
     * @param {number} times Сколько раз отправить уведомление
     */
    several: function(event, context, handler, times) {
      if (!events.has(event)) {
        events.set(event, []);
      }
      if (times <= 0) {
        events.get(event).push({ context, handler, type: 'on' });
      } else {
        events.get(event).push({ context, handler, type: 'several', num: times, counter: 0 });
      }

      return this;
    },

    /**
     * Подписка на событие с ограничением по частоте отправки уведомлений
     * @param {string} event
     * @param {Object} context
     * @param {Function} handler
     * @param {number} frequency Как часто уведомлять
     */
    through: function(event, context, handler, frequency) {
      if (!events.has(event)) {
        events.set(event, []);
      }
      if (frequency <= 0) {
        events.get(event).push({ context, handler, type: 'on' });
      } else {
        events.get(event).push({ context, handler, type: 'through', num: frequency, counter: 0 });
      }

      return this;
    }
  };
}

module.exports = {
  getEmitter,

  isExtraTaskSolved
};
