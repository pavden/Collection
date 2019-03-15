package ua.training.task2;

public interface MyList<E> extends Iterable<E> {

    boolean add(E e);
    E get(int index);
    int size();
    void update(int index, E e);

}
