package tree.segement;

public class TestSegTree {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (Merger<Integer>) (a, b) -> a + b);
        System.out.println(segmentTree);
    }
}
