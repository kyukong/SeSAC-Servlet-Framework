package com.sesac.project.mvc.fx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {

    protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response);
}
