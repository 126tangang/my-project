package usb;

/**
 * 实现了USB接口的打印机
 */
public class Printer implements USB{
    /**
     * 打印机开始工作
     */
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    /**
     * 打印机结束工作
     */
    @Override
    public void end() {
        System.out.println("打印机结束工作");
    }

    /**
     * 打印机具体执行的代码
     */
    @Override
    public void code() {
        System.out.println("打印机执行的代码");
    }
}
