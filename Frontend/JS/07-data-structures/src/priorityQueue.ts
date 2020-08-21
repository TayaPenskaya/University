import { Queue } from './queue';

export class PriorityQueue<T> {
  firstQ: Queue<T>;
  secondQ: Queue<T>;
  thirdQ: Queue<T>;

  constructor() {
    this.firstQ = new Queue<T>();
    this.secondQ = new Queue<T>();
    this.thirdQ = new Queue<T>();
  }

  enqueue(value: T, priority: number): void {
    switch (priority) {
      case 1:
        return this.firstQ.enqueue(value);
      case 2:
        return this.secondQ.enqueue(value);
      case 3:
        return this.thirdQ.enqueue(value);
    }
  }

  dequeue(): T | void {
    if (this.thirdQ.size !== 0) {
      return this.thirdQ.dequeue();
    } else if (this.secondQ.size !== 0) {
      return this.secondQ.dequeue();
    } else if (this.firstQ.size !== 0) {
      return this.firstQ.dequeue();
    }

    return undefined;
  }

  get size() {
    return this.firstQ.size + this.secondQ.size + this.thirdQ.size;
  }
}
