package com.sesac.project.mvc.fx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.java.Log;

@Log
@WebServlet(
    urlPatterns = {
        "/pilot/*",
        "/game/*",
        "/article/*"
    },
    loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private final Map<String, AbstractController> controllerMap = new HashMap<>();

    @Override
    public void init() {
        log.info("DispatcherServlet 접근");
        Properties prop = ResourcesReader.read("dispatcher-servlet.properties");
        try {
            for (Object oKey : prop.keySet()) {
                String key = ((String)oKey).trim();
                Class<?> className = null;
                try {
                    className = Class.forName(prop.getProperty(key).trim());
                    controllerMap.put(key, (AbstractController)className.getConstructor().newInstance());
                    log.info("🧡 loaded : " + className + " 🧡");
                } catch (Exception e) {
                    log.info(e.getMessage());
                    log.info("💔 error : " + className + " 💔");
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    }
}
