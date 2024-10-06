package controller;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author ByteBigBoss
 * @org ImaginecoreX
 */
@ServerEndpoint("/SocketEntry")
public class Socket {

    @OnOpen
    public void onOpen(Session session) throws IOException  {
        System.out.println("On Open");
        session.getBasicRemote().sendText("Server: Hello");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println(message);
        session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose() {
        System.out.println("On Close");
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("On Error");
    }
   
}
