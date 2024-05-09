package com.shen1991.vuln.jdni;

import io.javalin.Javalin;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class App {
    private final static Logger log = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.jetty.defaultHost = "127.0.0.1";
            config.jetty.defaultPort = 7070;
            config.useVirtualThreads = true;
            config.http.asyncTimeout = 10_000L;
        }).start();

        app.get("/hello", ctx -> {
            // some code
            ctx.result("Hello world!");
        });

        app.post("/api/log4j", ctx -> {
            String payload = ctx.formParam("payload");
            log.info("payload: {}", payload);
            ctx.result("logged");
        });
    }

}
