package tree;

public class TestClass {
    public static void main(String[] args) {
        BST<Integer> bts = new BST<>();
//        int[] ints={5,3,3,6,8,4,2};
//        for (int i:ints
//             ) {
//            bts.add(i);
//        }
//        bts.preTraverse();
//        bts.midTraverse();
//        bts.backTraverse();
//        bts.levelTraverse();
//        System.out.println(bts.minimum());
//        bts.removeMin();
//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//
//        int n = 100;
//
//        // test removeMin
        int[] ints={586,184,169,122,58,21,10,3,7,33,34,70,60,61,98,91,120,112,150,161,159,170,179,172,488,266,237,189,193,226,61,98,91,120,112,150,161,159,170,179,172,488,266,237,189,193,226,219,196,246,293,273,289,426,296,337,298,316,336,347,375,373,355,419,415,439,430,435,476,452,466,532,496,489,491,512,510,521,531,919,853,698,596,615,687,642,619,676,803,758,736,727,702,701,745,771,767,785,781,843,849,878,867,855,858,876,883,959,940,987,979,998};
        for(int i = 0 ; i < 95 ; i ++)
            bts.add(ints[i]);
        System.out.println(        bts.select(9));
        System.out.println(bts.rank(61));
//        bts.midTraverse();
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
