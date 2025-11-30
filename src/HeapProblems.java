import java.util.*;

public class HeapProblems {

    public static List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) pq.poll();
        }
        return new ArrayList<>(pq);
    }

    public static List<Integer> kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) pq.poll();
        }
        return new ArrayList<>(pq);
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x,0)+1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (var e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll()[0]);
        return res;
    }

    public static int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : ropes) pq.add(x);

        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }

    public static class MedianStream {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        public void add(int x) {
            if (max.isEmpty() || x <= max.peek()) max.add(x);
            else min.add(x);

            if (max.size() > min.size() + 1) min.add(max.poll());
            else if (min.size() > max.size()) max.add(min.poll());
        }

        public double median() {
            if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
            return max.peek();
        }
    }
}
