package com.huowolf.client;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @创建人：王小伟
 * @创建时间： 2019/9/6
 * @描述：
 */
public class WebsocketClient {
    private static Logger logger = LoggerFactory.getLogger(WebsocketClient.class);
    public static WebSocketClient client;
    public static void main(String[] args) {
        try {
            client = new WebSocketClient(new URI("ws://121.40.165.18:8800")) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    logger.info("握手成功");
                }

                @Override
                public void onMessage(String msg) {
                    logger.info("收到消息=========="+msg);
                    if(msg.equals("over")){
                        client.close();
                    }
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    logger.info("链接已关闭");
                }

                @Override
                public void onError(Exception e){
                    e.printStackTrace();
                    logger.info("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();

        while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            logger.info("正在连接...");
        }
        //连接成功,发送信息
        client.send("哈喽,连接一下啊");
    }


}
