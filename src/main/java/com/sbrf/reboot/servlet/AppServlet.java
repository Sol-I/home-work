package com.sbrf.reboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/hello")
public class AppServlet extends HttpServlet {
    private final AtomicInteger visitCounter;

    public AppServlet() {
        this.visitCounter = new AtomicInteger(0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (username == null) {
            printWriter.write("Hello, Anonymous" + "<br>");
        } else {
            printWriter.write("Hello, " + username + "<br>");
        }
        printWriter.write("Page was visited " + visitCounter.addAndGet(1) + " times.");
        printWriter.close();
    }
}

