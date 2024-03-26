package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if ((row == 0 && column == 0 && data[row].length != 0) || (row < data[row].length - 1)) {
            return true;
        }
        if (row == data.length - 1 && column >= data[row].length) {
            return false;
        }
        if (column > data[row].length - 1 && data[row].length != 0) {
            column = 0;
            row++;
        }
        while (data[row].length == 0) {
            row++;
            if (row == data.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}