export class Node<T> {
  public data: T | void;
  public next: Node<T> | null;
  public prev: Node<T> | null;

  constructor(data: T | void) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}
