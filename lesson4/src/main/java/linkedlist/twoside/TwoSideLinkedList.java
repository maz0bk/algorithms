package linkedlist.twoside;

public interface TwoSideLinkedList<E>  extends LinkedList<E>{

        void insertLeft(E value);
        void insertRight(E value);

        E removeLeft();

}
