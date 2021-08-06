package usb;

/**
 * USB接口
 */
public interface USB {
    /**
     * USB开始工作
     */
    void start();

    /**
     * USB结束工作
     */
    void end();

    /**
     * 具体执行的代码
     */
    void code();
}
