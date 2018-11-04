package heap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");

        Integer[] ints={586,184,169,122,58,21,10,3,7,33,34,70,60,61,98,91,120,112,150,161,159,170,179,172,488,266,237,189,193,226,61,98,91,120,112,150,161,159,170,179,172,488,266,237,189,193,226,219,196,246,293,273,289,426,296,337,298,316,336,347,375,373,355,419,415,439,430,435,476,452,466,532,496,489,491,512,510,521,531,919,853,698,596,615,687,642,619,676,803,758,736,727,702,701,745,771,767,785,781,843,849,878,867,855,858,876,883,959,940,987,979,998};
        arr=new int[ints.length];
        MaxHeap<Integer> maxHeap1 = new MaxHeap<Integer>(ints);
        for(int i = 0 ; i < n ; i ++)
            arr[i] = maxHeap.extractMax();
        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("test heapify completed");
    }
}
