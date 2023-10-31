package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputCarNameTest {

    InputCarName inputCarName = new InputCarName();

    @Test
    @DisplayName("자동차 이름 입력")
    void carNames() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> result = inputCarName.inputCar(input);

        // then
        List<String> expected = Arrays.asList("pobi", "woni", "jun");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열의 길이보다 큰 숫자 위치를 찾을 때 예외 발생")
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> result = inputCarName.inputCar(input);

        // then
        assertThatThrownBy(() -> {
            for (String name : result) {
                name.charAt(5);
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

    }

}