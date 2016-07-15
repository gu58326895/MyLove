package mytest.lang3.test;

import java.time.LocalDateTime;

public class Normal {
    private String name;

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().minusMonths(1));
    }

}
