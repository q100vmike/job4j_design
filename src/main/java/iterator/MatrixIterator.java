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
        if ((row == 0 && column == 0 && data[0].length != 0) || (row < data[column].length)) {
            return true;
        }
        if (row == data[column].length && column != data.length - 1) {
            while (data[column + 1].length == 0) {
                if (column ==  data.length - 2) {
                    break;
                }
                column++;
            }
            column++;
            if (data[column].length == 0) {
                return false;
            } else {
                row = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (row == 0 && column == 0) {
            row++;
            return data[0][0];
        }
        if (row < data[column].length) {
            row++;
            return data[column][row - 1];
        } else {
            row = 0;
        }
        return data[column][row];
    }
}