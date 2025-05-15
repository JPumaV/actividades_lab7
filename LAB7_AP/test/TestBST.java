package test;

import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class TestBST {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);

            System.out.println("InOrder: " + bst.showInOrder());
            System.out.println("PreOrder: " + bst.showPreOrder());
            System.out.println("PostOrder: " + bst.showPostOrder());

            System.out.println("Buscar 40: " + bst.search(40));
            System.out.println("Mínimo: " + bst.getMin());
            System.out.println("Máximo: " + bst.getMax());

            bst.delete(30);
            System.out.println("InOrder después de eliminar 30: " + bst.showInOrder());

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}