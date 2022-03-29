package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO GET 방식의 파라미터 전송 방식
//  Ex) localhost:8080/request-param?username=hello&age=20
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] 시작");

        // paramName 은 username, age 같은 부분
        // 여기서 키 값을 출력하기 위해선 username, age 를 인자로 request.getParameter() 메서드를 호출해야 한다.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - 끝");
        System.out.println();

        System.out.println("[단일 파라미터 조회 - 시작]");
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회 - 끝]");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - 시작");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - 끝");

        response.getWriter().write("ok");
    }
}
