package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    // parseInputToList에 대한 테스트
    @Test
    void 한_개의_이름_입력() {
        String input = "haein";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("haein"));
    }

    @Test
    void 여러_이름_입력() {
        String input = "haein,dobi,fine,";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("haein", "dobi", "fine"));
    }

    @Test
    void 다양한_문자_입력() {
        String input = "해바라기씨,rober,%#@$!,12345";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("해바라기씨", "rober", "%#@$!", "12345"));
    }

    @Test
    void 띄어쓰기로_구분_문자열_길이_5이하() {
        String input = "a b c";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("a b c"));
    }

    @Test
    void 띄어쓰기로_구분_문자열_길이_6자_이상() {
        String input = "haein dobi fine";

        assertThatThrownBy(() -> InputHandler.parseInputToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자 보다 큽니다. 5자리 이하로 입력해주세요.");

    }

    @Test
    void 빈값_입력() {
        String input = "";

        assertThatThrownBy(() -> InputHandler.parseInputToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있습니다. 값을 입력해주세요.");
    }

    // parseInputToIntager에 대한 테스트

    @Test
    void 숫자_0_입력() {
        String input = "0";

        assertThatThrownBy(() -> InputHandler.parseInputToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수가 아닌 입력값입니다. 양의 정수를 입력해주세요.");
    }

    @Test
    void 숫자_음수_값_입력() {
        String input = "-21421";

        assertThatThrownBy(() -> InputHandler.parseInputToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 입력값입니다. 숫자를 입력해주세요.");
    }

    @Test
    void 숫자_빈값_입력() {
        String input = "";
        assertThatThrownBy(() -> InputHandler.parseInputToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있습니다. 값을 입력해주세요.");
    }
}