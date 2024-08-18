package ru.bublinoid.http.server.web;

import ru.bublinoid.http.server.request.Request;

import java.io.IOException;
import java.io.OutputStream;

public interface MyWebApplication {
    void execute(Request request, OutputStream output) throws IOException;
}