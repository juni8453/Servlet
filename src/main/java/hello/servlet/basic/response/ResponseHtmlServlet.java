package hello.servlet.basic.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // HTML 파일을 응답해야 하기 때문에 text/html 타입으로 Content-Type 을 잡아준다.
        // 참고) Content-type 은 요청, 응답 헤더에 모두 정의될 수 있는 공통 속성이다.
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("Body 응답 완료");

    }
}
