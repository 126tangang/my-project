package block;

import org.junit.Test;

public class Person {
    static String desc;

    public Person() {

    }

    {
        desc = "非静态代码块2";
        System.out.println(desc);
    }

    static {
        desc = "静态代码块2";
        System.out.println(desc);
    }

    static {
        desc = "静态代码块1";
        System.out.println(desc);
    }

    {
        desc = "非静态代码块1";
        System.out.println(desc);
    }
}
