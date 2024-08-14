package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.client.MathClient;
import ru.bublinoid.otusbasic.server.MathServer;

public class Main {
    public static void main(String[] args) {

        new Thread(MathServer::startServer).start();

        MathClient.serverCommunication();

    }
}