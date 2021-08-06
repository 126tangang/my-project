package usb;

import org.junit.Test;

public class USBTest {
    @Test
    public void test() {
        Computer computer = new Computer();
        Flash flash = new Flash();
        Printer printer = new Printer();
//        computer.transferData(flash);
        computer.transferData(printer);
    }
}

