package mytest.lang3.test;


class Dog2 {
    public  void bark() {
        System.out.print("woof ");
    }
}
class Basenji extends Dog2 {
    public  void bark() { }
}
public class Bark {
    public static void main(String args[]) {
        Dog2 woofer = new Dog2();
        Dog2 nipper = new Basenji();
        woofer.bark();
        nipper.bark();
    }
}