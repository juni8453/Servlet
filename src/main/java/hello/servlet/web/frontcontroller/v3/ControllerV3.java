package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // 요청 파라미터를 받기 위한 Request, 응답을 위한 Response 종속성 제거 !
    ModelView process(Map<String, String> paramMap);
}
