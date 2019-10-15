package algorithmframe;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-14 00:38
 */
public class HeapAlgorithm {
    static int[] mergeSort;
    public static void main(String[] args) {


        int arr[] = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};
        Heap heap = new Heap(arr.length+1);

        for (int i = 0; i < arr.length; i++) {
            heap.insertHeap(arr[i]);
        }

        heap.print();

        for (int i = arr.length - 1; i >= 0; --i) {
            arr[i] = heap.deleteHeap();

        }
        print(arr);
    }

    static void print(int[] arr) {
        System.out.println();
        for(int i=0; i<arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}

class Heap {
    private int heapSize;
    private int arrHeap[];

    public Heap(int len) {
        heapSize = 0;
        arrHeap= new int[len];
    }

    public void insertHeap(int item) {
        int i = ++ heapSize;

        while ((i != 1) && (item > arrHeap[i / 2])) {
            arrHeap[i] = arrHeap[i / 2];
            i /= 2;
        }

        arrHeap[i] = item;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public int deleteHeap() {
        int parent, child;
        int item, tmp;
        item = arrHeap[1];
        tmp = arrHeap[heapSize--];
        parent = 1;
        child = 2;

        while (child <= heapSize) {
            if ((child < heapSize) && (arrHeap[child] < arrHeap[child + 1]))
                child++;

            if (tmp >= arrHeap[child])
                break;

            arrHeap[parent] = arrHeap[child];
            parent = child;
            child *= 2;
        }

        arrHeap[parent] = tmp;
        return item;
    }

    public void print() {
        for(int i=0; i<arrHeap.length; i++) {
            System.out.printf(arrHeap[i] + " ");
        }
        System.out.println();
    }
}