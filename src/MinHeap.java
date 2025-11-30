import java.util.*;

public class MinHeap {
    private List<Integer> heap = new ArrayList<>();

    public int size() { return heap.size(); }

    public void insert(int val) {
        heap.add(val);
        heapifyUp(size() - 1);
    }

    public int extractMin() {
        if (size() == 0) throw new NoSuchElementException("Empty heap");
        int root = heap.get(0);
        int last = heap.remove(size() - 1);
        if (size() > 0) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(i) < heap.get(p)) {
                Collections.swap(heap, i, p);
                i = p;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int n = size();
        while (true) {
            int l = 2*i + 1, r = 2*i + 2, s = i;
            if (l < n && heap.get(l) < heap.get(s)) s = l;
            if (r < n && heap.get(r) < heap.get(s)) s = r;
            if (s != i) {
                Collections.swap(heap, i, s);
                i = s;
            } else break;
        }
    }

    public String toString() { return heap.toString(); }
}
