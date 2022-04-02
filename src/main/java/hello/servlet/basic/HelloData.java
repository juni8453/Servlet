package hello.servlet.basic;

// 보통 JSON 은 그냥 사용히지 않고, 객체로 파싱해서 사용한다.

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
