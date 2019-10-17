package algorithmframe;

import java.util.EmptyStackException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-18 00:21
 */
public class ByStack<T> {
    private class StackNode {
        private T data;
        private StackNode next;
        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode newNode = new StackNode(item);
        newNode.next = this.top;
        this.top = newNode;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return this.top.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
