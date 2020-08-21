import { LinkedList } from './linkedList';

export class RingBuffer<T> {
  private list: LinkedList<T>;
  public capacity: number;

  constructor(capacity: number) {
    this.list = new LinkedList<T>();
    this.capacity = capacity;
  }

  get(i: number): T | void {
    return this.list.get(i);
  }

  push(value: T | void): void {
    if (this.capacity === this.size) {
      this.shift();
    }

    return this.list.push(value);
  }

  shift(): T | void {
    return this.list.shift();
  }

  static concat<T>(...buffers: RingBuffer<T>[]): RingBuffer<T> | void {
    const init = 0;
    const newCapacity = buffers.reduce((acc, currentValue) => acc + currentValue.capacity, init);

    const newBuffer = new RingBuffer<T>(newCapacity);
    buffers.forEach(buffer => {
      for (let i = 0; i < buffer.size; ++i) {
        newBuffer.push(buffer.get(i));
      }
    });

    return newBuffer;
  }

  get size(): number {
    return this.list.size;
  }
}
