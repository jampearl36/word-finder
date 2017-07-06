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
public class IntegrationTest {

    WordFinder wordFinder1;
    WordFinder wordFinder2;

    Matrix<Character> matrix;
    TrieDictionary dict;

    @Before
    public void before() {

        final String[] DEFAULT_PUZZLE = new String[] {
                "akjbvaijdsbv_d_dbv", "fjslkdfadsna_T_lfa","asdfasdfsdfa_r_ads", "ckvsadfgfgjava_ajd","akjbvaijdsbv_d_dbv",
                "cbvqiejdbfqi_e_qib", "asdjnaquekjdwdfabd", "asdk_word_kgrtuabd", "asdjnaquekjfghbdbd", "asewdfldfjdsfewrkf",
                "as_Shift_ejdccgabd"};


        matrix = Util.convertStringsToMatrix(DEFAULT_PUZZLE);

        dict = new TrieDictionary();
        dict.add("fadsna");
        dict.add("word");

        wordFinder1 = new HorizontalVerticalWordFinder(dict);
        wordFinder2 = new DiagonalWordFinder(dict);
    }

    @Test
    public void horizontalVerticalWords() {
        Set<String> set = wordFinder1.findWords(matrix);
        assertEquals("The set should be of size 2", 2, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("fadsna");
        expectedSet.add("word");

        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));
    }

    @Test
    public void diagonalWords() {

        dict.add("fa");
        Set<String> set = wordFinder2.findWords(matrix);
        assertEquals("The set should be of size 1", 1, set.size());

        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("fa");

        assertTrue("Set should be equal to expected set", expectedSet.containsAll(set));
    }
}
