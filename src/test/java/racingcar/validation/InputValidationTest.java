package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidationTest {

    @Test
    void validationName_자동차_이름을_검증_성공한다() {
        // given : 테스트를 진행하기 위해 필요한 값 세팅 및 설정
        String carName = "pobi";

        // when : 언제? 테스트 대상 메서드 실행
        // then : 실질적으로 검증하는 과정
        assertDoesNotThrow(() -> InputValidation.validateName(carName));
    }

    @ParameterizedTest
    @MethodSource("validationName_자동차_이름을_검증_실패한다")
    void validationName_자동차_이름을_검증_실패한다(String carName) {
        assertThatThrownBy(() -> InputValidation.validateName(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.CAR_NAME_LENGTH_VALIDATION_EXCEPTION);
    }

    private static Stream<Arguments> validationName_자동차_이름을_검증_실패한다() {
        return Stream.of(
            Arguments.of("     "),
            Arguments.of(""),
            Arguments.of("abcdefghijkl")
        );
    }
    @Test
    void validateAndSplit_자동차_콤마구분_검증_성공한다() {
        String carName = "pobi,crong";
        String[] result = carName.split(",");
        assertThat(result).contains("pobi", "crong");
        assertThat(result).containsExactly("pobi", "crong");
    }

    @ParameterizedTest
    @MethodSource("validateAndSplit_자동차_콤마구분_검증_실패한다")
    void validateAndSplit_자동차_콤마구분_검증_실패한다(String carName) {
        assertThatThrownBy(() -> InputValidation.validateNameAndSplit(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.CAR_NAME_SEPARATE_COMMA_EXCEPTION);
    }

    private static Stream<Arguments> validateAndSplit_자동차_콤마구분_검증_실패한다() {
        return Stream.of(
            Arguments.of("pobi",".","crong"),
            Arguments.of("pobi", "/", "crong")
        );
    }

    @Test
    void carSameNameValidation_자동차_이름이_다를경우_성공한다() {
        List<String> carName = List.of("pobi", "crong");
    }
}

