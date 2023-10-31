package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidationTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하이면 입력값 반환")
    void carNameValidateOKTest() {
        // given
        List<String> input = Stream.of("pobi","woni","jun")
                .collect(Collectors.toList());
        // when
        List<String> result = InputValidation.carNameValidate(input);
        // then
        Assertions.assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 오류 반환")
    void carNameValidateFailTest() {
        // given
        List<String> input = Stream.of("pobipobi","woni","jun")
                .collect(Collectors.toList());
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.carNameValidate(input);
        });
    }

    @Test
    @DisplayName("시도할 횟수는 Int형이어야한다")
    void gameCountValidateOKTest() {
        // given
        String count ="5";
        // when
        String countValidate = InputValidation.gameCountValidate(count);
        // then
        Assertions.assertThat(countValidate).isEqualTo(count);
    }

    @Test
    @DisplayName("시도할 횟수가 Int형이 아니면 오류를 반환")
    void gameCountValidateFailTest() {
        // given
        String count="망";
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.gameCountValidate(count);
        });
    }

    @Test
    @DisplayName("시도할 횟수가 자연수가 아닐시 오류를 반환")
    void gameCountNotNaturalNumberTest() {
        // given
        String count="-6";
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.gameCountValidate(count);
        });
    }
}