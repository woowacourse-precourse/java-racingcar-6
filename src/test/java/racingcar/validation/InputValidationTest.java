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


}