package newcoll.tree;

public interface Queue<T> {
    public void push(T element);
    public T poll();
    public int size();
}
