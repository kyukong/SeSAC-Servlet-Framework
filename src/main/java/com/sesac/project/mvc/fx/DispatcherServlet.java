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
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String action = requestURI.substring(contextPath.length());

        try {
            AbstractController controller = controllerMap.get(action);
            if (controller == null) {
                throw new RuntimeException("controller is null");
            }
            ModelAndView mav = controller.handleRequestInternal(request, response);
            if (mav == null) {
                throw new RuntimeException("model and view is null");
            }

            String viewName = mav.getViewName();
            if (viewName.startsWith("redirect:")) {
                response.sendRedirect(viewName.substring(9));
            } else {
                Map<String, Object> model = mav.getModel();
                for (String key : model.keySet()) {
                    request.setAttribute(key, model.get(key));
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
                dispatcher.forward(request, response);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
