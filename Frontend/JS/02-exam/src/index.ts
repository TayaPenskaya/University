import { promiseRace } from './example';

function getValueSoon(value: number, timeout: number): Promise<number> {
  return new Promise(resolve => {
    setTimeout(() => resolve(value), timeout*Math.random());
  });
}

function throwErrorSoon(error: Error, timeout: number): Promise<number> {
  return new Promise((_, reject) => {
    setTimeout(() => reject(error), timeout);
  });
}

promiseRace([getValueSoon(1, 1000), getValueSoon(2, 1000), getValueSoon(3, 1000)])
  .then(result => {
  console.log('This should be 1:', result);
});

promiseRace([
  throwErrorSoon(new Error('Boom!'), 1000),
  getValueSoon(2, 2000),
  getValueSoon(3, 3000)
])
  .then(results => {
    console.log('We should not get here');
    console.log(results);
  })
  .catch((error: Error) => {
    console.error(error);
  });
