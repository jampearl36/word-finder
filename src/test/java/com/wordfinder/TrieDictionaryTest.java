package com.wordfinder;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by ktangirala on 7/5/17.
 */
public class TrieDictionaryTest {

    TrieDictionary dictionary;

    @Before
    public void before() {
        dictionary = new TrieDictionary();
    }

    @Test
    public void emptyTrie() {
        assertFalse("has is not a valid word in trie", dictionary.isValidWord("has"));
        assertFalse("has is not a valid word in trie", dictionary.isValidPrefix("has"));
    }

    @Test
    public void testExistingPrefix() {
        dictionary.add("good");
        assertTrue("g is a valid prefix", dictionary.isValidPrefix("g"));
        assertTrue("go is a valid prefix", dictionary.isValidPrefix("go"));
        assertTrue("goo is a valid prefix", dictionary.isValidPrefix("goo"));
        assertTrue("good is a valid prefix", dictionary.isValidPrefix("good"));
    }

    @Test
    public void testNonExistingPrefix() {
        dictionary.add("good");
        assertFalse("ga is an invalid prefix", dictionary.isValidPrefix("ga"));
    }

    @Test
    public void testExistingWords() {
        dictionary.add("good");
        dictionary.add("goods");
        dictionary.add("and");
        assertTrue("good is a valid word", dictionary.isValidWord("good"));
        assertTrue("goods is a valid word", dictionary.isValidWord("goods"));
        assertTrue("and is a valid word", dictionary.isValidWord("and"));
    }

    @Test
    public void testNonExistingWords() {
        dictionary.add("good");
        dictionary.add("goods");
        dictionary.add("and");
        assertFalse("goo is an invalid word", dictionary.isValidWord("goo"));
        assertFalse("bad is an invalid word", dictionary.isValidWord("bad"));
        assertFalse("gooda is a valid word", dictionary.isValidWord("gooda"));
    }
}
