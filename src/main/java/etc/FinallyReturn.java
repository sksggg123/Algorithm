package etc;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-19 13:41
 */
public class FinallyReturn {
    public static void main(String[] args) {
        FinallyReturn finallyReturn = new FinallyReturn();
        finallyReturn.test_1();
        finallyReturn.test_2();
    }

    public boolean test_1() {
        try {
            return Boolean.TRUE;
        } catch (Exception e) {
            //
        } finally {
            System.out.println("Finally Check!!");
            return Boolean.FALSE;
        }
    }

    public boolean test_2() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return Boolean.FALSE;
        } finally {
            System.out.println("Finally Check!!");
        }
    }
}
