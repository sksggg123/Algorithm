package etc;

import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-19 13:09
 */
public class CollectionType {

    public static void main(String[] args) {
        CollectionType collectionType = new CollectionType();
        /* ArrayList */
        collectionType.arrayList();
        /* Vector */
        collectionType.vector();
        /* LinkedList */
        collectionType.linkedList();


        TestInner inner = new TestInner(1);
    }

    /**
     * 중복허용
     * null허용
     * 중간값 삭제시 index로 접근 but 삭제 후 재배열에 소모가 큼.
     */
    public void arrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(null);

        list.stream()
                .forEach(System.out::println);

        System.out.println();
    }

    /**
     * 중복허용
     * null허용
     * 동기화 지원
     * 중간값 삭제시 index로 접근 but 삭제 후 재배열에 소모가 큼.
     */
    public void vector() {
        Vector vector = new Vector();
        vector.add("two");
        vector.add(0, "one");
        vector.add("one");
        vector.add(null);

        vector.stream()
                .forEach(System.out::println);

        System.out.println();
    }

    /**
     * 중복허용
     * null허용
     * remove() 할시 처음 element가 삭제 됨.
     */
    public void linkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.addFirst(1);
        linkedList.add(null);

        Iterator it = linkedList.iterator();
        while(it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
        System.out.println();
    }

    public static class TestInner {
        private static int test;

        private TestInner(int test) {
            this.test = test;

        }
    }
}
