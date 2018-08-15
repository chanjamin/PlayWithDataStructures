package tree;

public class TestClass {
    public static void main(String[] args) {
        BTS<Integer> bts = new BTS<>();
        for (int i = 0; i < 10; i++) {
            bts.add(i);
        }
        System.out.println();
    }
}
