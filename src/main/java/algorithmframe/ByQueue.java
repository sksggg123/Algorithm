package algorithmframe;

import java.util.NoSuchElementException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-18 00:36
 */

public class ByQueue<T> {

    public static void main(String[] args) {
        ByQueue que = new ByQueue();

        que.add(1);
        que.add(2);
        que.add(3);

        System.out.println("peek\t : " + que.peek());
        System.out.println("remove\t : " + que.remove());
        System.out.println("isEmpty\t : " + que.isEmpty());
        System.out.println("remove\t : " + que.remove());
        System.out.println("remove\t : " + que.remove());
        System.out.println("isEmpty\t : " + que.isEmpty());
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;

    public void add(T data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        }

        /* last가 null 이면 last에 신규 node를 넣는다. */
        /* last가 null 아니면 last.next에 신규 node를 넣고, 기존 last에 신규 node를 넣는다. */
        if (last != null) {
            /* 최초 진입시 last와 신규 node가 같다. 그 말은 같은 주소값을 바라보고있다. 주소값이 같다는 건 같은 객체라는 뜻. */
            /* first == last이고, last.next == first.next가 된다. */
            last.next = newNode;
        }
        last = newNode;

        /**
         * Line 53 ~ 58의 step 별 상태값 정리
         * step1) node1 - first : node1
         *              - last  : node1
         * step2) node2 - first : node1                             Line 56 수행 전
         *              - last  : node1                             Line 56 수행 전
         *              - fist  : node1.next = node2                Line 56 수행 후
         *              - last  : node1.next = node2                Line 56 수행 후
         *              - first : node1.next = node2                Line 58 수행 후
         *              - last  : node2                             Line 58 수행 후
         * step3) node3 - first : node1.next = node2                Line 56 수행 전
         *              - last  : node2                             Line 56 수행 전
         *              - fist  : node1.next(node2).next = node3    Line 56 수행 후
         *              - last  : node2.next = node3                Line 56 수행 후
         *              - first : node1.next(node2).next = node3    Line 58 수행 후
         *              - last  : node3                             Line 58 수행 후
         *
         * 3개의 node 추가 후 결과는
         * node의 first는 그대로 유지되며, last의 next node에 신규 node를 붙이면서 유지한다.
         */
    }

    public T peek() {
        if (this.first == null) throw new NoSuchElementException();
        return this.first.data;
    }

    public T remove() {
        if (this.first == null) throw new NoSuchElementException();
        T retData = this.first.data;
        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        return retData;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

}
