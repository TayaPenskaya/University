export class HashNode<T> {
  key: number | string | object;
  value: T;

  constructor(key: number | string | object, value: T) {
    this.key = key;
    this.value = value;
  }
}
