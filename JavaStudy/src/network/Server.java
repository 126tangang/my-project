package network;

/**
 * 被代理服务器
 */
public class Server implements Network{

    /**
     * 被代理服务器访问网络
     */
    @Override
    public void browse() {
        System.out.println("被代理服务器访问网络");
    }
}
