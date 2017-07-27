package com.wordfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktangirala on 7/5/17.
 */
public class Util {

    private Util() {

    }

    /**
     * Convert the list of strings to Matrix
     * @param strings
     * @return
     */
    public static Matrix<Character> convertStringsToMatrix(String[] strings) {

        Matrix<Character> matrix = new Matrix<>(strings.length);
        for(int i=0;i<strings.length;i++)  {

            List<Character> characters = new ArrayList<>();
            for(char c : strings[i].toCharArray()) {
                characters.add(c);
            }

            matrix.add(characters);
        }

        return matrix;
    }

    /**
     * Create and return a new Matrix similar to matrix and fill all slots with value
     * @param matrix
     * @param value
     * @param <T>
     * @return
     */
    public static <T> Matrix<T> createAndFill(Matrix matrix, T value) {

        Matrix<T> newMatrix = new Matrix<>(matrix.rowSize());

        for(int i=0;i<matrix.rowSize();i++) {
            List<T> list = new ArrayList<>(matrix.colSize(i));
            for(int j=0;j<matrix.colSize(i);j++) {
                list.add(value);
            }
            newMatrix.add(list);
        }

        return newMatrix;
    }
}
