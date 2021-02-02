package com.project.util.constants;

public class View {

    public static final String VIEW_LOGIN = "/WEB-INF/views/pages/login/login.jsp";
    // VIEWS
    public static final String VIEW_HOME = "/WEB-INF/views/index.jsp";
    public static final String VIEW_DETAIL = "/WEB-INF/views/pages/detail/detail.jsp";
    public static final String VIEW_500 = "/WEB-INF/views/pages/error/500.jsp";
    public static final String VIEW_INTERNSHIP = "/WEB-INF/views/pages/internship/internship.jsp";

    private View() {
        throw new IllegalStateException("Utility class");
    }
}
