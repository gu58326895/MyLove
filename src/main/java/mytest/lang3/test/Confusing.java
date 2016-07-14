package mytest.lang3.test;

/**
 * Created by darcy on 2016/1/29.
 */
public class Confusing {

    private Confusing(double[] dArray) {
        System.out.println("double array");
    }
    private Confusing(Object o) {
        System.out.println("Object");
    }
    public static void main(String[] args) {
        new Confusing(null);
    }
}
