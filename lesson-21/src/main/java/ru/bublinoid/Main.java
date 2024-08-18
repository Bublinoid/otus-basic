package ru.bublinoid;

import ru.bublinoid.client.MathClient;
import ru.bublinoid.server.MathServer;

public class Main {
    public static void main(String[] args) {

        new Thread(MathServer::startServer).start();

        MathClient.serverCommunication();

    }
}