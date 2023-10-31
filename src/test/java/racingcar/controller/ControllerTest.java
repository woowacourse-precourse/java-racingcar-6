package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {

    private static Controller controller;

    @BeforeEach
    void 초기화() {
        controller = new Controller();
    }

    @Test
    void 자동차_이름_공백_예외처리() {
        String input = "jaavi, ,jon";
        String[] result = input.split(",");

        assertThatThrownBy(() -> controller.checkInvalidate(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 공백이 들어갑니다.");
    }

    @Test
    void 자동차_이름_글자수_예외처리() {
        String input = "longName,hon,javvvi";
        String[] result = input.split(",");

        assertThatThrownBy(() -> controller.checkInvalidate(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 다섯 글자가 넘습니다.");
    }

    @Test
    void 자동차_이름_중복_예외처리() {
        String input = "java,java";
        String[] result = input.split(",");

        assertThatThrownBy(() -> controller.checkInvalidate(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }

}