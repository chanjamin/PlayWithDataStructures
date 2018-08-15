package tree;

public class TestClass {
    public static void main(String[] args) {
        BTS<Integer> bts = new BTS<>();
        int[] ints={5,3,6,8,4,2};
        for (int i:ints
             ) {
            bts.add(i);
        }
        bts.preTraverse();
        bts.midTraverse();
        bts.backTraverse();
    }
}
