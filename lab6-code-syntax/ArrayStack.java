public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int t = -1;  // top index
    private static final int CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E element) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t--] = null; // avoid memory leak
        return answer;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
}
