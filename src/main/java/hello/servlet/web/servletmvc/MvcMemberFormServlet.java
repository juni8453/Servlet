package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // /WEB-INF 디렉터리 내부에 JSP 를 넣은 이유는, 해당 디렉토리 내부에 JSP 파일이 있다면 직접적으로 URL 로 JSP 파일을 호출할 수 없다.
        // 즉, 컨트롤러(Servlet) 를 무조건 거쳐서 JSP 파일을 호출하기 위해서 넣어준 것.
        // 그러니까, RequestDispatcher ~ forward() 메서드를 통해서만 호출할 수 있는 것이다.
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // Controller 에서 View 로 이동할 때 사용하는 getRequestDispatcher() 메서드
        // 이후 forward(req, res) 메서드는 다른 Servlet 이나 JSP 로 이동할 수 있는 메서드이다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
