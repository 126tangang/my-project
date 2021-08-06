package exercise.demo1;

import org.junit.Test;

public class InterfaceTest {
    @Test
    public void test() {
        ComparableCircle comparableCircle1 = new ComparableCircle(2.6);
        ComparableCircle comparableCircle2 = new ComparableCircle(1.2);
        String string = "";

//        System.out.println(comparableCircle1.compareTo(comparableCircle2));
        System.out.println(comparableCircle1.compareTo(string));
    }
}
