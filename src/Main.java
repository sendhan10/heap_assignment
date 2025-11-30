import java.util.*;

public class Main {
    public static void main(String[] args) {

        MinHeap mh = new MinHeap();
        mh.insert(5); mh.insert(2); mh.insert(9);
        System.out.println("MinHeap: " + mh);
        System.out.println("Extract Min: " + mh.extractMin());

        MaxHeap xh = new MaxHeap();
        xh.insert(4); xh.insert(15); xh.insert(7);
        System.out.println("MaxHeap: " + xh);
        System.out.println("Extract Max: " + xh.extractMax());

        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort.sort(arr);
        System.out.println("Heap Sort: " + Arrays.toString(arr));

        System.out.println("K largest: " + HeapProblems.kLargest(new int[]{7,10,4,3,20,15}, 3));
        System.out.println("K smallest: " + HeapProblems.kSmallest(new int[]{7,10,4,3,20,15}, 3));

        System.out.println("Top 2 frequent: " + HeapProblems.topKFrequent(new int[]{1,1,1,2,2,3}, 2));

        System.out.println("Connect Ropes Min Cost: " + HeapProblems.connectRopes(new int[]{4,3,2,6}));

        HeapProblems.MedianStream ms = new HeapProblems.MedianStream();
        ms.add(5); ms.add(15); ms.add(1); ms.add(3);
        System.out.println("Median: " + ms.median());
    }
}
