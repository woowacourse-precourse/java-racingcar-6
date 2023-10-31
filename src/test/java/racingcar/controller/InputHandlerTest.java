package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    // parseInputToList에 대한 테스트
    @Test
    void 입력값이_하나일_때() {
        String input = "haein";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("haein"));
    }

    @Test
    void 입력값_끝에_쉼표가_들어갈_때() {
        String input = "haein,dobi,fine,";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("haein", "dobi", "fine"));
    }

    @Test
    void 영어_외_다른_글자도_정상동작하는지_확인() {
        String input = "해바라기씨,rober,%#@$!,12345";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("해바라기씨", "rober", "%#@$!", "12345"));
    }

    @Test
    void 쉼표가아닌_띄어쓰기로_구분했을_때_문자열의_길이가_5보다_작다면() {
        String input = "a b c";
        List<String> result = InputHandler.parseInputToList(input);
        assertThat(result).isEqualTo(Arrays.asList("a b c"));
    }

    @Test
    void 쉼표가아닌_띄어쓰기로_구분했을_때_문자열의_길이가_5보다_크다면() {
        String input = "haein dobi fine";

        assertThatThrownBy(() -> InputHandler.parseInputToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자 이상입니다. 5자리 이하로 입력해주세요.");

    }

    @Test
    void 빈값이_들어갔을_때() {
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
    void 숫자_음수의_값_입력() {
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