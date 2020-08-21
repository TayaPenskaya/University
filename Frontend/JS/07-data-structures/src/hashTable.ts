import { HashNode } from './hashNode';

export class HashTable<T> {
  public size: number;
  array: Array<HashNode<T>[]>;

  constructor() {
    this.size = 0;
    this.array = new Array<HashNode<T>[]>();
  }

  get(key: number | string | object): T | void {
    const hash = this.getHash(key);
    const node = this.array[hash].find(e => e.key === key);

    return node?.value;
  }

  put(key: number | string | object, element: T): void {
    const hash = this.getHash(key);
    if (!this.array[hash]) {
      this.array[hash] = [];
    }

    this.array[hash].push(new HashNode<T>(key, element));
    this.size++;

    return;
  }

  getHash(key: number | string | object): number {
    const keyStr = typeof key === 'string' ? key : JSON.stringify(key);
    let hash = 0;
    const p = 31;
    for (let i = 0; i < keyStr.length; ++i) {
      hash += keyStr.charCodeAt(i) * p;
    }

    return hash % this.array.length;
  }

  clear(): void {
    this.size = 0;
    this.array = new Array<HashNode<T>[]>();
  }
}
