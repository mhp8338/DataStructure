package avltree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("/Users/xuepipi/Desktop/mhpExercise/DataStructure/src/main/avltree/pride-and" +
                "-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<String, Integer>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("is BST: " + map.isBST());
            System.out.println("is balanced: " + map.isBalanced());

            for(String word:words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()){
                    throw new RuntimeException("Error");
                }
            }

            System.out.println("end");
        }
    }
}
