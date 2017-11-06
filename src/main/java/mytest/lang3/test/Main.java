package mytest.lang3.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by darcy on 2016/3/9.
 */
public class Main {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }


    /**
     * 34      * @desc Person类。
     * 35
     */
    private static class Person {
        int age;
        String name;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " + age;
        }

        /**
         * 50          * @desc重写hashCode
         * 51
         */
        @Override
        public int hashCode() {
            int nameHash = name.toUpperCase().hashCode();
            return nameHash ^ age;
        }

        /**
         * 59          * @desc 覆盖equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            //如果是同一个对象返回true，反之返回false
            if (this == obj) {
                return true;
            }

            //判断是否类型相同
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }

}
