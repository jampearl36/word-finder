package com.wordfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by ktangirala on 7/3/17.
 *
 * A Main class which uses the horizontal/vertical and diagonal finders
 * to find words in a matrix
 */
public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.findWords();
    }

    public void findWords() {

        final String[] DEFAULT_PUZZLE = new String[] {
                "akjbvaijdsbv_d_dbv", "fjslkdfadsna_T_lfa","asdfasdfsdfa_r_ads", "ckvsadfgfgjava_ajd","akjbvaijdsbv_d_dbv",
                "cbvqiejdbfqi_e_qib", "asdjnaquekjdwdfabd", "asdk_word_kgrtuabd", "asdjnaquekjfghbdbd", "asewdfldfjdsfewrkf",
                "as_Shift_ejdccgabd"};


        Matrix<Character> matrix = Util.convertStringsToMatrix(DEFAULT_PUZZLE);

        TrieDictionary dict = new TrieDictionary();
        dict.add("fadsna");
        dict.add("word");

        System.out.println("Horizontal/Vertical words are");
        WordFinder wordFinder1 = new HorizontalVerticalWordFinder(dict);
        printSet(wordFinder1.findWords(matrix));

        dict.add("fa");

        System.out.println("Diagonal words are");
        WordFinder wordFinder2 = new DiagonalWordFinder(dict);
        printSet(wordFinder2.findWords(matrix));

    }

    private static void printSet(Set<String> set) {
        for(String word : set) {
            System.out.println(word);
        }
    }
}
