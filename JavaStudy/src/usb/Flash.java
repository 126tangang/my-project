package usb;

/**
 * 实现USB接口的U盘
 */
public class Flash implements USB{
    /**
     * U盘开始工作
     */
    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    /**
     * U盘结束工作
     */
    @Override
    public void end() {
        System.out.println("U盘结束工作");
    }

    /**
     * U盘具体执行的代码
     */
    @Override
    public void code() {
        System.out.println("U盘执行的代码");
    }
}
