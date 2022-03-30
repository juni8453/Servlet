package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Status Line]");
        response.setStatus(HttpServletResponse.SC_OK);

        System.out.println("[Response Header]");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");

        System.out.println("[내가 원하는 임의의 헤더도 세팅 가능]");
        response.setHeader("my-header", "hello");

        // Response Header 의 편의 메서드
        content(response);

        // Response Cookie 설정 메서드
        cookie(response);

        // Response Redirect 설정 메서드
        redirect(response);

        // Response Body 에 내용 담기
        response.getWriter().write("서버 응답 완료");
    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        // response.setContentLength(); 는 응답 헤더 필수 값이지만 생략 가능 (생략하면 알아서 Body 길이를 계산해준다)
        response.setCharacterEncoding("UTF-8");

    }
}
