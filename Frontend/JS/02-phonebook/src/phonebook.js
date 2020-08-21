'use strict';

/**
 * Если вы решили сделать дополнительное задание и реализовали функцию importFromDsv,
 * то выставьте значение переменной isExtraTaskSolved в true.
 */
const isExtraTaskSolved = true;

class Entry {
  constructor(phone, name, email = '') {
    this.phone = phone;
    this.name = name;
    this.email = email;
  }
}
/**
 * Телефонная книга
 */
const phoneBook = [];

function isString(name) {
  return typeof name === 'string';
}

function checkPhone(phone) {
  return isString(phone) && /^\d{10}$/.test(phone);
}

function checkName(name) {
  return isString(name) && name.length > 0;
}
/**
 * Добавление записи в телефонную книгу
 * @param {string} phone
 * @param {string} [name]
 * @param {string} [email]
 * @returns {boolean}
 */
function add(phone, name, email) {
  if (
    !(
      checkPhone(phone) &&
      checkName(name) &&
      phoneBook.findIndex(entry => entry.phone === phone) === -1 &&
      (isString(email) || email === undefined)
    )
  ) {
    return false;
  }

  phoneBook.push(new Entry(phone, name, email));

  return true;
}

/**
 * Обновление записи в телефонной книге
 * @param {string} phone
 * @param {string} [name]
 * @param {string} [email]
 * @returns {boolean}
 */
function update(phone, name, email) {
  const ind = phoneBook.findIndex(entry => entry.phone === phone);
  if (
    !(
      checkPhone(phone) &&
      checkName(name) &&
      ind !== -1 &&
      (isString(email) || email === undefined)
    )
  ) {
    return false;
  }

  phoneBook[ind] = new Entry(phone, name, email);

  return true;
}

function formatPhone(phone) {
  return `+7 (${phone.slice(0, 3)}) ${phone.slice(3, 6)}-${phone.slice(6, 8)}-${phone.slice(
    8,
    10
  )}`;
}

function formatEntries(arr) {
  return arr
    .map(entry =>
      entry.email.length > 0
        ? `${entry.name}, ${formatPhone(entry.phone)}, ${entry.email}`
        : `${entry.name}, ${formatPhone(entry.phone)}`
    )
    .sort();
}

function commonFind(query) {
  return phoneBook.filter(
    entry =>
      entry.phone.includes(query) ||
      entry.name.includes(query) ||
      (entry.email !== undefined && entry.email.includes(query))
  );
}
/**
 * Поиск записей по запросу в телефонной книге
 * @param {string} query
 * @returns {string[]}
 */
function find(query) {
  if (!isString(query) || query.length === 0) {
    return [];
  }
  if (query === '*') {
    return formatEntries(phoneBook);
  }
  const res = commonFind(query);
  if (res.length !== 0) {
    return formatEntries(res);
  }

  return [];
}

/**
 * Удаление записей по запросу из телефонной книги
 * @param {string} query
 * @returns {number}
 */
function findAndRemove(query) {
  if (!isString(query) || query.length === 0) {
    return 0;
  }
  const length = phoneBook.length;
  if (query === '*') {
    phoneBook.splice(0);

    return length;
  }

  const res = commonFind(query);
  for (let i = 0; i < res.length; ++i) {
    phoneBook.splice(phoneBook.indexOf(res[i]), 1);
  }

  return res.length;
}

/**
 * Импорт записей из dsv-формата
 * @param {string} dsv
 * @returns {number} Количество добавленных и обновленных записей
 */
function importFromDsv(dsv) {
  if (!isString(dsv) || dsv.length === 0) {
    return 0;
  }
  const entries = dsv.split('\n').map(x => x.split(';'));
  let added = 0;
  for (const [name, phone, email] of entries) {
    if (add(phone, name, email) || update(phone, name, email)) {
      ++added;
    }
  }

  return added;
}

module.exports = {
  add,
  update,
  find,
  findAndRemove,
  importFromDsv,

  isExtraTaskSolved
};
