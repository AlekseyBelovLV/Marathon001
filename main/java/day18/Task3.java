package day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Вам необходимо создать двоичное дерево поиска, изображенное на картинке выше.
* Для этого создайте класс “Узел” (англ. Node), объекты которого будут содержать само значение узла
и поля-ссылки на два других узла (левый и правый сын).
* Затем, создайте корневой (англ. root) узел (со значением 20).
* После этого, необходимо реализовать метод, который будет добавлять новые узлы в ваше дерево.
Этот метод должен принимать в качестве аргументов добавляемое значение и ссылку на корень дерева.
Проходясь по дереву, он должен вставлять новый узел в правильное место дерева.
* Когда двоичное дерево, изображенное выше, будет создано, необходимо используя рекурсию вывести в
консоль все числа из этого двоичного дерева поиска в отсортированном виде. Ваше рекурсивное решение
должно работать для любого корректного двоичного дерева поиска. Этот алгоритм называется “обход в
глубину” (иногда называют “поиск в глубину”). Ваш рекурсивный метод (пусть он будет называться dfs)
должен в качестве единственного аргумента принимать ссылку на корень дерева (root).
    Вызов: dfs(root);
    Вывод в консоль: 5 8 11 14 15 16 18 20 22 23 24 27 150
*/

public class Task3 {
        public static void main(String[] args) {
            Tree tree = new Tree();
            tree.insertNode(20);
            tree.insertNode(14);
            tree.insertNode(23);
            tree.insertNode(11);
            tree.insertNode(16);
            tree.insertNode(22);
            tree.insertNode(27);
            tree.insertNode(5);
            tree.insertNode(15);
            tree.insertNode(18);
            tree.insertNode(24);
            tree.insertNode(150);
            tree.insertNode(8);

            System.out.println(tree.dfs(tree.getRootNode()));
        }
}

class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public Node getLeftChild() { return leftChild; }
    public void setLeftChild(Node leftChild) { this.leftChild = leftChild; }
    public Node getRightChild() { return rightChild; }
    public void setRightChild(Node rightChild) { this.rightChild = rightChild; }

    public String toString() { return "Node value " + this.value +
            ", leftChild " + this.leftChild +
            ", rightChlid " + this.rightChild;
    }
}

class Tree {
    private Node rootNode;
    static List<Integer> nodeValueList = new ArrayList<>();
    Tree() { this.rootNode = null; }

    public Node getRootNode() { return rootNode; }

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if(this.rootNode == null) {
            this.rootNode = newNode;
        } else {
            Node currentNode = this.rootNode;
            Node parentNode;
            while(true) {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {
                    return;
                } else if(value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if(currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if(currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public List<Integer> dfs(Node node) {
        nodeValueList.add(node.getValue());

        if(node.getLeftChild() != null) {
            Node currentNode = node.getLeftChild();
            dfs(currentNode);
        }
        if(node.getRightChild() != null) {
            Node currentNode = node.getRightChild();
            dfs(currentNode);
        }
        Collections.sort(nodeValueList);
        return nodeValueList;
    }

}

