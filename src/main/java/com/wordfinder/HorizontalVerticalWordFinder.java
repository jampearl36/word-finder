package com.wordfinder;

import java.util.Set;

/**
 * Created by ktangirala on 7/4/17.
 */
public class HorizontalVerticalWordFinder extends WordFinder {

    public HorizontalVerticalWordFinder(Dictionary dictionary) {
        super(dictionary);
    }


    @Override
    protected void goInDirection(final Matrix<Character> matrix, final int row, final int col,
                                 final StringBuilder prefix, final Matrix<Boolean> visited, final Set<String> result) {

        // Vertical and horizontal
        dfs(matrix, row - 1, col, prefix, visited, result);
        dfs(matrix, row + 1, col, prefix, visited, result);
        dfs(matrix, row, col - 1, prefix, visited, result);
        dfs(matrix, row, col + 1, prefix, visited, result);
    }
}
