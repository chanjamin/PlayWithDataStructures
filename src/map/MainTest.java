package map;

import map.bst.BSTMap;
import map.linkedlist.LinkedListMap;
import util.FileOperation;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile( MainTest.class.getResource("/").getPath()+"pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

//            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
