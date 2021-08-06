package test;

import org.junit.Test;

public class TestAll {
    @Test
    public void test() {
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("*******************");
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
