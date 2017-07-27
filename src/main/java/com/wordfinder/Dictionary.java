package com.wordfinder;

/**
 * Created by ktangirala on 7/3/17.
 */
public interface Dictionary {

    /**
     * Given a word, check if it's a valid
     * word in the dictionary.
     * @param word
     * @return
     */
    boolean isValidWord(String word);

    /**
     * Given a prefix, check if it's a valid
     * prefix in the dictionary
     * @param prefix
     * @return
     */
    boolean isValidPrefix(String prefix);

}
