package com.wordfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktangirala on 7/3/17.
 */
public class Matrix<E> {

    int noOfRows;
    private List<List<E>> matrix;

    public Matrix(int rowSize) {
        noOfRows = rowSize;
        matrix = new ArrayList<>(noOfRows);
    }

    public void add(List<E> list) {

        List<E> row = new ArrayList<>(list.size());
        for(E ch : list) {
            row.add(ch);
        }

        matrix.add(row);
    }

    public E get(int row, int col) {

        validateRowAndCol(row, col);

        return (E) matrix.get(row).get(col);
    }

    public void set(int row, int col, E element) {
        validateRowAndCol(row, col);
        matrix.get(row).set(col, element);

    }

    public int rowSize() {
        return matrix.size();
    }

    public int colSize(int row) {
        if (row >= rowSize()) {
            throw new ArrayIndexOutOfBoundsException("Row " + row + " >= number of total rows " + rowSize());
        }

        return matrix.get(row).size();
    }

    private void validateRowAndCol(int row, int col) {
        if (row >= rowSize()) {
            throw new ArrayIndexOutOfBoundsException("Row " + row + " >= number of total rows " + rowSize());
        }

        if (col >= colSize(row)) {
            throw new ArrayIndexOutOfBoundsException("Col " + col + " >= number of total cols " + colSize(row));
        }
    }

}
