'use strict';

const assert = require('assert');

const { replaceLog, BinaryTree, formatString } = require('../src/warmup');

describe('log', () => {
  it('Должна вернуть print', () => {
    assert.strictEqual(replaceLog('log'), 'print');
  });
});

const tree = new BinaryTree();
tree.insert(8);
tree.insert(2);
tree.insert(11);
tree.insert(10);
tree.insert(3);
tree.insert(5);

describe('tree', () => {
  it('preorder-0', () => {
    assert.strictEqual(formatString(tree.preorderTraversal()), '8 2 3 5 10 11');
  });

  it('preorder-1', () => {
    tree.delete(3);
    assert.strictEqual(formatString(tree.preorderTraversal()), '8 2 5 10 11');
  });

  it('inorder-0', () => {
    assert.strictEqual(formatString(tree.inorderTraversal()), '2 5 8 10 11');
  });

  it('inorder-1', () => {
    tree.delete(5);
    tree.insert(6);
    assert.strictEqual(formatString(tree.inorderTraversal()), '2 6 8 10 11');
  });

  it('inorder-2', () => {
    tree.insert(12);
    assert.strictEqual(formatString(tree.inorderTraversal()), '2 6 8 10 11 12');
  });
});
