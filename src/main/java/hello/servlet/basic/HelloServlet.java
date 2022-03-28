package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// name, urlPatterns 이름은 곂치면 안된다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        // getParameter() : 웹 브라우저 요청 쿼리를 굉장히 쉽게 읽을 수 있도록 지원
        String username = request.getParameter("username");
        System.out.println(username);

        // set ~() : 서버에서 웹 브라우저로 응답을 설정할 수 있는 여러가지 메서드 지원
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("Hello " + username);
    }
}
