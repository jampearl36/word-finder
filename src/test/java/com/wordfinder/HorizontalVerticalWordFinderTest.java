package com.wordfinder;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ktangirala on 7/5/17.
 */
public class HorizontalVerticalWordFinderTest {

    HorizontalVerticalWordFinder wordFinder;

    public void setUp(Dictionary dictionary) {
        wordFinder = new HorizontalVerticalWordFinder(dictionary);
    }

    @Before
    public void before() {
        setUp(createDictionaryAllValidWordsAndPrefix());
    }

    @Test
    public void emptyListOfStrings() {

        final String[] strings = new String[] {};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be empty", 0, set.size());
    }

    @Test
    public void allStringsValid1Row() {

        final String[] strings = new String[] {"ab"};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be of size 4", 4, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("a");
        expectedSet.add("b");
        expectedSet.add("ab");
        expectedSet.add("ba");

        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));
    }

    @Test
    public void allStringsValidMoreThan1Row() {

        final String[] strings = new String[] {"ab", "de"};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be of size 28", 28, set.size());
    }

    @Test
    public void allStringsValidMoreThan1RowColumnSizeDifferent() {

        final String[] strings = new String[] {"ab", "d"};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be of size 9", 9, set.size());
    }

    private Dictionary createDictionaryAllValidWordsAndPrefix() {
        return new Dictionary() {
            @Override
            public boolean isValidWord(String word) {
                return true;
            }

            @Override
            public boolean isValidPrefix(String prefix) {
                return true;
            }
        };
    }
}
