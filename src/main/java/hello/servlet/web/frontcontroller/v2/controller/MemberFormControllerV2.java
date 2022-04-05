package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    // 컨트롤러 입장에서 HttpServletRequest, HttpServletResponse 가 꼭 필요한가 ? (서블릿의 종속성 제거 필요)
    // 그리고 현재 viewPath 에는 디렉토리 구조가 몽땅 들어가는데 이러면 jsp 파일이 옮겨지면 컨트롤러도 함께 수정해야 한다.
    // 따라서 물리적인 경로를 다 집어넣는게 아니라, 논리적인 이름만 viewPath 로 넣어주도록 변경한다. (new-form 만)
    // 실제로 물리적인 경로는 프론트 컨트롤러에서 처리하도록 하자.
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
