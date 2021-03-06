package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // RequestBodyStringServlet 클래스에서 Body 의 단순 텍스트를 출력하는 것과 동일하다.
    // 왜냐하면, HTTP 메시지 바디 데이터를 출력하는 것이 동일하기 떄문이다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        // JSON 을 객체로 파싱하기 위해서는 ObjectMapper 클래스의 도움이 필요하다.
        // readValue() 메서드에 받은 messageBody, 파싱하고 싶은 객체를 인자로 넣어주면 된다.
        // 참고) ObjectMapper를 이용할경우 setter가 없이도 필드에 접근할 수 있다
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("helloData.getUsername = " + helloData.getUsername());
        System.out.println("helloData = " + helloData.getAge());

//        JSON 데이터를 뽑기 위해 한번 연습 ㅎ_ㅎ
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        String responseBody = objectMapper.writeValueAsString(helloData);
//
//        response.getWriter().write(responseBody);

        response.getWriter().write("ok");
    }
}
