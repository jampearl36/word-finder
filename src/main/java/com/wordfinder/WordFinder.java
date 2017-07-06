package com.wordfinder;

import java.util.*;

/**
 * Created by ktangirala on 7/3/17.
 */
public abstract class WordFinder {

    protected Dictionary dictionary;

    public WordFinder(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Set<String> findWords(Matrix<Character> matrix) {

        Set<String> result = new HashSet<>();
        Matrix<Boolean> visited = Util.createAndFill(matrix, Boolean.FALSE);

        for(int i=0;i<matrix.rowSize();i++) {
            for(int j=0;j<matrix.colSize(i);j++) {
                dfs(matrix, i, j, new StringBuilder(""), visited, result);
            }
        }

        return result;

    }

    protected void dfs(final Matrix<Character> matrix, final int row, final int col, StringBuilder prefix,
                     final Matrix<Boolean> visited, final Set<String> result) {

        if (row < 0 || col < 0 || row >= matrix.rowSize() || col >= matrix.colSize(row)) {
            return;
        }

        if (visited.get(row, col)) {
            return;
        }

        prefix = prefix.append(matrix.get(row, col));

        // If the prefix is invalid eliminate unnecessary recursion
        if (dictionary.isValidPrefix(prefix.toString())) {

            visited.set(row, col, true);

            if (dictionary.isValidWord(prefix.toString())) {
                result.add(prefix.toString());
            }

            // delegate the direction to goto to the subclass
            // template method pattern
            goInDirection(matrix, row, col, prefix, visited, result);

            visited.set(row, col, false);
        }

        prefix = prefix.deleteCharAt(prefix.length()-1);

    }

    protected abstract void goInDirection(final Matrix<Character> matrix, final int row, final int col, final StringBuilder prefix,
                                          final Matrix<Boolean> visited, final Set<String> result);
}
