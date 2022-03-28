package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);
        printHeaderUtils(request);
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("Headers 편의 조회 시작");
        System.out.println("--------------------------------");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        System.out.println("모든 언어 정보 출력");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("웹 브라우저에 설정된 가장 선호하는 언어 정보 출력");
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie 편의 조회 시작]");
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }
        System.out.println();

        // GET 방식으로 테스트하면 null 이 도출된다. 왜 ?
        // GET 방식으로 요청하면 Content 를 거의 보내지 않는다. (일반적으로)
        // HTTP Body 에 내용이 담겨져 있어야 Content 가 의미가 있는거라 GET 방식은 아무래도 null 이 출력되는 것.
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--------------------------------");
        System.out.println("Headers 편의 조회 끝");
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("Start Line 시작");
        String method = request.getMethod();
        System.out.println("method = " + method);

        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);

        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);

        // Https 사용 여부
        boolean secure = request.isSecure();
        System.out.println("secure = " + secure);
        System.out.println("Start Line 끝");
        System.out.println();
    }

    private void printHeader(HttpServletRequest request) {
        System.out.println("Headers 시작");
        System.out.println("--------------------------------");

        // Header 정보를 출력하는 방법 [1]
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + " = " + headerName);
        }

        // Header 정보를 출력하는 방법 [2]
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName + " = " + headerName));

        System.out.println("--------------------------------");
        System.out.println("Headers 끝");
    }
}
