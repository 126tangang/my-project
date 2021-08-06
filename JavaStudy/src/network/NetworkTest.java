package network;

import org.junit.Test;

/**
 * 代理模式
 */
public class NetworkTest {
    @Test
    public void test() {
        Server server = new Server();

        ProxyServer proxyServer = new ProxyServer(server);

        proxyServer.browse();
    }
}
