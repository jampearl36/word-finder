package com.wordfinder;

import java.util.Set;

/**
 * Created by ktangirala on 7/5/17.
 */
public class DiagonalWordFinder extends WordFinder {

    public DiagonalWordFinder(Dictionary dictionary) {
        super(dictionary);
    }

    @Override
    protected void goInDirection(final Matrix<Character> matrix, final int row, final int col,
                                 final StringBuilder prefix, final Matrix<Boolean> visited, final Set<String> result) {

        // Diagonals
        dfs(matrix, row - 1, col - 1, prefix, visited, result);
        dfs(matrix, row + 1, col + 1, prefix, visited, result);
        dfs(matrix, row - 1, col + 1, prefix, visited, result);
        dfs(matrix, row + 1, col - 1, prefix, visited, result);

    }
}
