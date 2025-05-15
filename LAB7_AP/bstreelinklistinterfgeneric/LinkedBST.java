package bstreelinklistinterfgeneric;

import bstreeinterface.BinarySearchTree;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node root;

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null)
            return new Node(data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = insert(node.left, data);
        else if (cmp > 0)
            node.right = insert(node.right, data);
        else
            throw new ItemDuplicated("Dato duplicado: " + data);
        return node;
    }

    @Override
    public E search(E data) throws ItemNotFound {
        Node result = search(root, data);
        if (result == null)
            throw new ItemNotFound("Dato no encontrado: " + data);
        return result.data;
    }

    private Node search(Node node, E data) {
        if (node == null)
            return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            return search(node.left, data);
        else if (cmp > 0)
            return search(node.right, data);
        else
            return node;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNotFound {
        if (root == null)
            throw new ExceptionIsEmpty("El árbol está vacío.");
        root = delete(root, data);
    }

    private Node delete(Node node, E data) throws ItemNotFound {
        if (node == null)
            throw new ItemNotFound("Dato no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = delete(node.left, data);
        else if (cmp > 0)
            node.right = delete(node.right, data);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node min = findMinNode(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private Node findMaxNode(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public E getMin() throws ItemNotFound {
        if (root == null)
            throw new ItemNotFound("Árbol vacío");
        return findMinNode(root).data;
    }

    public E getMax() throws ItemNotFound {
        if (root == null)
            throw new ItemNotFound("Árbol vacío");
        return findMaxNode(root).data;
    }

    public String showInOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    public String showPreOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    public String showPostOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    @Override
    public String toString() {
        return "InOrder: " + showInOrder();
    }
}