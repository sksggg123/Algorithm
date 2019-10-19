package etc;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-19 13:37
 */
public class PrivateInner {
    private TestInner inner;
    private int data;

    public PrivateInner(int data) {
        this.data = data;
        this.inner = new TestInner(data + 1);
    }

    public int getData(int data) {
        return this.inner.getInnerData(data);
    }

    public class TestInner {
        private int innerData;

        private TestInner(int innerData) {
            this.innerData = innerData;
        }

        public int getInnerData(int data) {
            return this.innerData + data;
        }
    }
}
