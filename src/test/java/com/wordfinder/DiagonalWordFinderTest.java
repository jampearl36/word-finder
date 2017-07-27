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
public class DiagonalWordFinderTest {

    DiagonalWordFinder wordFinder;

    public void setUp(Dictionary dictionary) {
        wordFinder = new DiagonalWordFinder(dictionary);
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
        assertEquals("The set should be of size 2", 2, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("a");
        expectedSet.add("b");

        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));

    }

    @Test
    public void allStringsValidMoreThan1Row() {

        final String[] strings = new String[] {"ab", "de"};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be of size 8", 8, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("ae");
        expectedSet.add("bd");
        expectedSet.add("ea");
        expectedSet.add("db");
        expectedSet.add("a");
        expectedSet.add("b");
        expectedSet.add("d");
        expectedSet.add("e");


        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));
    }

    @Test
    public void allStringsValidMoreThan1RowColumnSizeDifferent() {

        final String[] strings = new String[] {"ab", "d"};
        Matrix<Character> matrix = Util.convertStringsToMatrix(strings);

        Set<String> set = wordFinder.findWords(matrix);
        assertEquals("The set should be of size 5", 5, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("bd");
        expectedSet.add("db");
        expectedSet.add("a");
        expectedSet.add("b");
        expectedSet.add("d");

        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));
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
