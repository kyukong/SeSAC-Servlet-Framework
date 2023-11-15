package com.sesac.project.mvc.fx;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelAndView {

    private String viewName;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        setViewName(viewName);
    }

    public ModelAndView(String viewName, String key, Object value) {
        setViewName(viewName);
        addObject(key, value);
    }

    public void addObject(String key, Object value) {
        model.put(key, value);
    }
}
