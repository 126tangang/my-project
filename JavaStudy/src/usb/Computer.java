package usb;

/**
 * 具体的计算机
 */
public class Computer {

    /**
     * 传输数据
     * @param usb
     */
    public void transferData(USB usb) {
        usb.start();

        usb.code();

        usb.end();
    }
}
