public class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY]; // can’t do new T[] in Java
        size = 0;
    }

    public void add(T element) {
        if (size == data.length) resize(); // if full grow first
        data[size] = element;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];

        for (int i = index; i < size - 1; i++) { // shift left
            data[i] = data[i + 1];
        }

        data[size - 1] = null; // clear last spot
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] bigger = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


