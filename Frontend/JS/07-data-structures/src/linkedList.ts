import { Node } from './node';

export class LinkedList<T> {
  private head: Node<T> | null;
  private tail: Node<T> | null;
  size: number;

  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  get(i: number): T | void {
    if (i < 0 || i >= this.size) {
      return undefined;
    }

    let node = this.head;
    let index = 0;
    while (node && index < i) {
      node = node.next;
      index++;
    }

    if (node) {
      return node.data;
    }

    return undefined;
  }

  push(value: T | void): void {
    const newNode = new Node<T>(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
      this.size++;

      return;
    }
    if (this.tail) {
      this.tail.next = newNode;
    }
    newNode.prev = this.tail;
    this.tail = newNode;
    this.size++;

    return;
  }

  unshift(value: T): void {
    const newNode = new Node<T>(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
      this.size++;

      return;
    }
    this.head.prev = newNode;
    newNode.next = this.head;
    this.head = newNode;
    this.size++;

    return;
  }

  pop(): T | void {
    if (this.tail) {
      const tmp = this.tail;
      this.tail = this.tail.prev;
      this.size--;

      return tmp.data;
    }

    return undefined;
  }

  shift(): T | void {
    if (this.head) {
      const tmp = this.head;
      this.head = this.head.next;
      this.size--;

      return tmp.data;
    }

    return undefined;
  }
}
