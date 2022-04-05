package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {

        // 실제 물리적인 경로는 프론트 컨트롤러에서 처리하기 때문에 논리적인 이름만 넣어주면 된다.
        return new ModelView("new-form");
    }
}
