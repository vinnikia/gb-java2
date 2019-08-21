package lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

//            System.out.println("socket.getPort() "+ socket.getPort());
//            System.out.println("socket.getLocalPort() "+socket.getLocalPort());
//
//            System.out.println("socket.getInetAddress() "+socket.getInetAddress());
//            System.out.println("socket.getLocalSocketAddress() "+socket.getLocalSocketAddress());
//            System.out.println("socket.getRemoteSocketAddress() "+socket.getRemoteSocketAddress());


            new Thread(() -> {
                try {
                    // цикл авторизации
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth ")) {
                            String[] token = str.split(" ");
//                            String[] token = str.split(" +",3);
                            String newNick = AuthService.getNickByLoginAndPass(token[1], token[2]);
                            if (newNick != null) {
                                sendMSG("/authok");
                                nick = newNick;
                                server.subscribe(this);
                                System.out.println("Клиент " + nick + " авторизовался");
                                break;
                            } else {
                                sendMSG("Неверный логин / пароль");
                            }
                        }
                    }
                    //цикл работы
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }

                        boolean isPrivateMsg = false;
                        String toNick = null;
                        if(str.startsWith("/w")) {
                            String[] parts = str.split(" +",3);
                            try {
                                if (parts.length == 2) {
                                    throw new IllegalArgumentException("Сообщение не указано");
                                } else if (parts.length <= 1) {
                                    throw new IllegalArgumentException("Ник получателя не указан");
                                }
                                toNick = parts[1];
                                if (!AuthService.isUserExists(toNick)) {
                                    throw new IllegalArgumentException("Получатель не найден. Сообщение не доставлено");
                                }
                            } catch (IllegalArgumentException e) {
                                sendMSG(e.getMessage());
                                continue;
                            }

                            isPrivateMsg = true;
                            str = parts[2];

                        }
                        if(isPrivateMsg) {
                            server.privateMsg(toNick,nick + " : " + str);
                        } else {
                            server.broadcastMsg(nick + " : " + str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    System.out.println("Клиент " + nick + " отключился");
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return this.nick;
    }

    public void sendMSG(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
