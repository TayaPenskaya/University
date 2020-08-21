console.log('start');

const promise = new Promise((resolved, rejected) => {
  const A = new Promise(res => {
    setTimeout(function timeout() {
      console.log("5");
      res(5);
    }, 5000);
  })
    .then(resolved)
    .catch(rejected);

  const C = new Promise(res => {
    setTimeout(function timeout() {
      console.log("3");
      res(3);
    }, 3000);
  })
    .then(resolved)
    .catch(rejected);

  const B = new Promise(res => {
    setTimeout(function timeout() {
      console.log("1");
      res(1);
    }, 1000);
  })
    .then(resolved)
    .catch(rejected);
}).then(res => console.log('res'));

console.log("Welcome to loupe.");
