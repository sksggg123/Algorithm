package algorithmframe;

import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-15 23:25
 */
public class BFSAlgorithm {

    public static final int SIZE = 10;
    public static int num = 0;

    public static void main(String[] args) {
        BFSAlgorithm bfs = new BFSAlgorithm();
        bfs.run();
    }

    public void run() {
        Point[][] points = new Point[SIZE][SIZE];
        Queue<Point> bfs = new LinkedList<>();
        boolean[] visit = new boolean[SIZE];

        /* init Points Status */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                points[i][j] = new Point();
            }
        }

        /* init Points Print */
        print(points);

        /* start Point */
        int startPoint = 0;
        visit[startPoint] = Boolean.TRUE;
        for (int i = 0; i < SIZE; i++) {
            Point point = points[startPoint][i];

            if (point.edge && visit[i]) {
                point.visited = Boolean.TRUE;
                bfs.add(points[startPoint][i]);
            }
        }

        print(points);

    }

    public void print(Point[][] points) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(points[i][j].toString() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public class Point {
        private int display;
        private boolean edge;
        private boolean visited;

        public Point() {
            this.display = -1;
            this.edge = new Random().nextBoolean();
            this.visited = Boolean.FALSE;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(display + " [");
            if (this.edge) {
                sb.append("O");
            } else {
                sb.append("X");
            }
            if (this.visited) {
                sb.append("*] ");
            } else {
                sb.append("-] ");
            }
            return sb.toString();
        }
    }
}
