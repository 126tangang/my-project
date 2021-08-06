package network;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * 代理服务器
 */
public class ProxyServer implements Network{
    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    /**
     * 代理服务器访问网络
     */
    @Override
    public void browse() {
        check();

        network.browse();
    }

    /**
     * 代理服务器访问网络前的检查工作
     */
    public void check() {
        System.out.println("代理服务器访问网络前的检查工作");
    }
}
