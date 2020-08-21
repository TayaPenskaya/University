import { LinkedList } from './linkedList';

export class Queue<T> {
  private list: LinkedList<T>;

  constructor() {
    this.list = new LinkedList<T>();
  }

  get(i: number): T | void {
    return this.list.get(this.list.size - 1 - i);
  }

  enqueue(value: T | void): void {
    return this.list.push(value);
  }

  dequeue(): T | void {
    return this.list.shift();
  }

  get size(): number {
    return this.list.size;
  }
}
