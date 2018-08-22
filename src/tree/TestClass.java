package tree;

import java.util.ArrayList;
import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        BST<Integer> bts = new BST<>();
        int[] ints={5,3,3,6,8,4,2};
        for (int i:ints
             ) {
            bts.add(i);
        }
        bts.preTraverse();
//        bts.midTraverse();
//        bts.backTraverse();
//        bts.levelTraverse();
//        System.out.println(bts.minimum());
//        bts.removeMin();
//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//
//        int n = 1000;
//
//        // test removeMin
//        for(int i = 0 ; i < n ; i ++)
//            bst.add(random.nextInt(10000));
//
//        ArrayList<Integer> nums = new ArrayList<>();
//        while(!bst.isEmpty())
//            nums.add(bst.removeMin());
//
//        System.out.println(nums);
//        for(int i = 1 ; i < nums.size() ; i ++)
//            if(nums.get(i - 1) > nums.get(i))
//                throw new IllegalArgumentException("Error!");
//        System.out.println("removeMin test completed.");
//        Integer floor = bts.floor(7);
//        System.out.println(floor);
    }
}
