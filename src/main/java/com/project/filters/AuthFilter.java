package com.project.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.project.util.constants.Attribute.SESSION_USER;
import static com.project.util.constants.Path.PATH_LOGIN;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {

    @Override
    public void destroy() {
        // Do nothing
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (isLogged(req)) {
            chain.doFilter(req, resp);
        } else ((HttpServletResponse) resp).sendRedirect(req.getServletContext().getContextPath() + PATH_LOGIN);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Do nothing
    }

    private boolean isLogged(ServletRequest request) {
        return ((HttpServletRequest) request).getSession().getAttribute(SESSION_USER) != null;
    }

}
