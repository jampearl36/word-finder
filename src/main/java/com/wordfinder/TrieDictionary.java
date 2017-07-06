package com.wordfinder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ktangirala on 7/3/17.
 */
public class TrieDictionary implements Dictionary {

    private static final char ROOT_DATA = ' ';

    private Node root;

    public TrieDictionary() {
        root = new Node(ROOT_DATA, false);
    }

    public void add(String word) {

        word = normalize(word);

        Node currNode = root;

        for(int i=0;i<word.length();i++) {
            char currCh = word.charAt(i);

            Node child = currNode.children.get(currCh);
            if (child == null) {

                child = new Node(currCh, false);
                currNode.children.put(currCh, child);
            }

            currNode = child;
        }
        currNode.setEndNode(true);
    }


    @Override
    public boolean isValidWord(String word) {
        Node endNode = search(word);
        return endNode != null && endNode.isEndNode;
    }

    @Override
    public boolean isValidPrefix(String prefix) {
        return search(prefix) != null;
    }

    private Node search(String string) {

        string = normalize(string);

        Node currNode = root;
        for(int i=0;i<string.length();i++) {

            char currCh = string.charAt(i);
            Node child = currNode.children.get(currCh);

            if (child == null) {
                return null;
            }
            currNode = child;
        }

        return currNode;
    }

    private String normalize(String word) {
        return word.toLowerCase();
    }

    private static class Node {

        private char data;
        private Map<Character, Node> children;
        private boolean isEndNode;

        Node(char data, boolean isEndNode) {
            this.data = data;
            this.isEndNode = isEndNode;

            children = new HashMap<>();
        }

        void setEndNode(boolean isEndNode) {
            this.isEndNode = isEndNode;
        }
    }
}
