'use strict';

function replaceLog(str) {
  return str.replace(/log/g, 'print');
}

class Node {
  constructor(key) {
    this.key = key;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {
  constructor() {
    this.root = null;
  }

  insert(k) {
    const insertNode = (node, k) => {
      if (!node) {
        return new Node(k);
      } else if (k < node.key) {
        node.left = insertNode(node.left, k);
      } else if (k > node.key) {
        node.right = insertNode(node.right, k);
      }
      return node;
    };

    this.root = insertNode(this.root, k);
  }

  minimum(x = this.root) {
    if (!x.left) {
      return x;
    }
    return this.minimum(x.left);
  }

  delete(k) {
    const deleteNode = (node, k) => {
      if (!node) {
        return node;
      }
      if (k < node.key) {
        node.left = deleteNode(node.left, k);
      } else if (k > node.key) {
        node.right = deleteNode(node.right, k);
      } else if (node.left && node.right) {
        node.key = this.minimum(node.right).key;
        node.right = deleteNode(node.right, node.key);
      } else {
        return node.left ? node.left : node.right ? node.right : null;
      }

      return node;
    };

    this.root = deleteNode(this.root, k);
  }

  inOrderTraversal(x = this.root) {
    let traversal = '';
    if (x) {
      traversal += `${this.inOrderTraversal(x.left)} ${x.key} ${this.inOrderTraversal(x.right)}`;
    }
    return traversal;
  }

  preOrderTraversal(x = this.root) {
    let traversal = '';
    if (x) {
      traversal += `${x.key} ${this.preOrderTraversal(x.left)} ${this.preOrderTraversal(x.right)}`;
    }
    return traversal;
  }
}

function formatString(str) {
  return str
    .replace(/^\s/, '')
    .replace(/\s\s+/g, ' ')
    .replace(/\s$/, '');
}

function printTree(tree) {
  if (tree instanceof BinaryTree) {
    console.log(formatString(tree.inOrderTraversal()));
  } else {
    console.error('Given argument is not a BinaryTree!');
  }
}

function printPreOrderTree(tree) {
  if (tree instanceof BinaryTree) {
    console.log(formatString(tree.preOrderTraversal()));
  } else {
    console.error('You print not a tree!');
  }
}

// Usage
const tree = new BinaryTree();
tree.insert(8);
tree.insert(2);
tree.insert(10);
tree.insert(12);
tree.insert(4);
tree.insert(5);

//2 4 5 8 10 12
printTree(tree);
// Given argument is not a BinaryTree!
printTree(3);
tree.delete(10);
//8 2 4 5 12
printPreOrderTree(tree);
tree.delete(8);
//12 2 4 5
printPreOrderTree(tree);

module.exports = {
  replaceLog,
  Node,
  BinaryTree,
  formatString
};
