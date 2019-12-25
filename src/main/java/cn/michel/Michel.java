package cn.michel;


/**
 * Michel核心的主启动类，在这里将Michel核心的一系列工作组织起来
 * 事实上，在服务端开启后主线程已经关闭，正在工作的则是服务端的线
 * 程。
 *
 * @author MagicLu
 */
public class Michel {

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
