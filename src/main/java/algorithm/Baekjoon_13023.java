package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_13023 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int before = sc.nextInt();
            int after = sc.nextInt();
            Person p = new Person(before, after);
            list.add(p);
        }
        sc.close();

        for (Person person : list) {
            System.out.println(person.getBefore() + " | " + person.getAfter());
        }


    }
}

class Person {
    private int before;
    private int after;
    private Person beP;
    private Person afP;

    Person(int before, int after) {
        this.before = before;
        this.after = after;
    }

    public Person getBeP() {
        return beP;
    }

    public Person getAfP() {
        return afP;
    }

    public int getBefore() {
        return before;
    }

    public int getAfter() {
        return after;
    }
}
