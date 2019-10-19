package etc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-19 14:08
 */
public class MapType {

    private Map<String, Person> hashMap;
    private Map<String, Person> treeMap;
    private Map<String, Person> linkedHashMap;

    public static void main(String[] args) {
        MapType type = new MapType();
        type.run();
    }

    public void run() {
        Person person1 = new Person("A", 10);
        Person person2 = new Person("C", 11);
        Person person3 = new Person("B", 12);

        this.hashMap = new HashMap<>();
        this.treeMap = new TreeMap<>();
        this.linkedHashMap = new LinkedHashMap<>();

        this.hashMap.put(person1.getName(), person1);
        this.hashMap.put(person2.getName(), person2);
        this.hashMap.put(person3.getName(), person3);

        this.treeMap.put(person1.getName(), person1);
        this.treeMap.put(person2.getName(), person2);
        this.treeMap.put(person3.getName(), person3);

        this.linkedHashMap.put(person1.getName(), person1);
        this.linkedHashMap.put(person2.getName(), person2);
        this.linkedHashMap.put(person3.getName(), person3);

        print("hashMap", this.hashMap);
        print("treeMap", this.treeMap);
        print("linkedHashMap", this.linkedHashMap);
    }

    public void print(String type, Map<String, Person> map) {
        System.out.println(type);
        map.keySet().stream()
                .forEach(key -> System.out.println("key : " + key + " value" + map.get(key).toString()));
    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
