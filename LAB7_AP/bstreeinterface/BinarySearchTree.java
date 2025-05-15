package bstreeinterface;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws ItemDuplicated;

    E search(E data) throws ItemNotFound;

    void delete(E data) throws ExceptionIsEmpty, ItemNotFound;

    String toString();
}