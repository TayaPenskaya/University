'use strict';

/**
 * @typedef {Object} Friend
 * @property {string} name Имя
 * @property {'male' | 'female'} gender Пол
 * @property {boolean} best Лучший ли друг?
 * @property {string[]} friends Список имён друзей
 */
Iterator.prototype.filterFriends = function() {
  const filteredFriends = [];

  let currentBest = this.friends.filter(f => f.best);
  const used = new Set();
  let currentLevel = 0;
  const nextBest = [];

  while (currentBest.length > 0 && currentLevel < this.maxLevel) {
    currentBest
      .sort((a, b) => a.name.localeCompare(b.name))
      .forEach(friend => {
        filteredFriends.push(friend);
        used.add(friend.name);
        nextBest.push(...friend.friends);
      });

    currentBest = this.friends.filter(
      friend => !used.has(friend.name) && nextBest.includes(friend.name)
    );
    ++currentLevel;
  }

  return filteredFriends.filter(this.filter.genderCheck);
};

/**
 * Итератор по друзьям
 * @constructor
 * @param {Friend[]} friends Список друзей
 * @param {Filter} filter Фильтр друзей
 */
function Iterator(friends, filter) {
  if (!(filter instanceof Filter)) {
    throw new TypeError('Wrong type of filter');
  }

  this.friends = friends;
  this.filter = filter;
  this.maxLevel = this.maxLevel || Infinity;
  this.index = 0;

  this.guests = this.filterFriends();

  this.done = function() {
    return this.index === this.guests.length;
  };

  this.next = function() {
    return this.done() ? null : this.guests[this.index++];
  };
}

/**
 * Итератор по друзям с ограничением по кругу
 * @extends Iterator
 * @constructor
 * @param {Friend[]} friends Список друзей
 * @param {Filter} filter Фильтр друзей
 * @param {Number} maxLevel Максимальный круг друзей
 */
function LimitedIterator(friends, filter, maxLevel) {
  maxLevel > 0
    ? ((this.maxLevel = maxLevel), Iterator.call(this, friends, filter))
    : Iterator.call(this, [], filter);
}
LimitedIterator.prototype = Object.create(Iterator.prototype);

/**
 * Фильтр друзей
 * @constructor
 */
function Filter() {
  this.genderCheck = () => true;
}

/**
 * Фильтр друзей-парней
 * @extends Filter
 * @constructor
 */
function MaleFilter() {
  this.genderCheck = ({ gender }) => gender === 'male';
}
MaleFilter.prototype = Object.create(Filter.prototype);

/**
 * Фильтр друзей-девушек
 * @extends Filter
 * @constructor
 */
function FemaleFilter() {
  this.genderCheck = ({ gender }) => gender === 'female';
}
FemaleFilter.prototype = Object.create(Filter.prototype);

module.exports = {
  Iterator,
  LimitedIterator,
  Filter,
  MaleFilter,
  FemaleFilter
};
