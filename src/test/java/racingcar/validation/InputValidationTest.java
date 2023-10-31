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
    void validateNameAndSplit도_자동차_콤마구분_검증_성공한다() {
        String carName = "pobi,crong";
        String[] result = carName.split(",");
        assertThat(result).contains("pobi", "crong");
        assertThat(result).containsExactly("pobi", "crong");
        assertDoesNotThrow(() -> InputValidation.validateNameAndSplit(carName));
    }

    @ParameterizedTest
    @MethodSource("validateNameAndSplit_자동차_콤마구분_검증_실패한다")
    void validateAndSplit_자동차_콤마구분_검증_실패한다(String carName) {
        assertThatThrownBy(() -> InputValidation.validateNameAndSplit(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.CAR_NAME_SEPARATE_COMMA_EXCEPTION);
    }

    private static Stream<Arguments> validateNameAndSplit_자동차_콤마구분_검증_실패한다() {
        return Stream.of(
            Arguments.of("pobi", ".", "crong"),
            Arguments.of("pobi", "/", "crong")
        );
    }

    @Test
    void validateIsNumber_자동차_경주_게임_시도_횟수가_숫자일경우_성공한다() {
        String number = String.valueOf(1);
        assertDoesNotThrow(() -> InputValidation.validateIsNumber(number));
    }

    @ParameterizedTest
    @MethodSource("validateIsNumber_자동차_경주_게임_시도_횟수가_숫자가_아닐경우_실패한다")
    void validateIsNumber_자동차_경주_게임_시도_횟수가_숫자가_아닐경우_실패한다(String number) {
        assertThatThrownBy(() -> InputValidation.validateIsNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.RACE_GAME_TRY_NUMBER);
    }

    private static Stream<Arguments> validateIsNumber_자동차_경주_게임_시도_횟수가_숫자가_아닐경우_실패한다() {
        return Stream.of(
            Arguments.of("a"),
            Arguments.of("."),
            Arguments.of("/")
        );
    }

    @ParameterizedTest
    @MethodSource("validateNameList_자동차_이름_검증에_성공한다")
    void validateNameList_자동차_이름_검증에_성공한다(List<String> carNames) {
        assertDoesNotThrow(() -> InputValidation.validateNameList(carNames));
    }

    private static Stream<Arguments> validateNameList_자동차_이름_검증에_성공한다() {
        return Stream.of(
            Arguments.of(List.of("pobi")),
            Arguments.of(List.of("pobi", "crong"))
        );
    }

    @ParameterizedTest
    @MethodSource("validateNameList_자동차_이름_검증에_실패한다")
    void validateNameList_자동차_이름_검증에_실패한다(List<String> carNames, String failureMessage) {
        assertThatThrownBy(() -> InputValidation.validateNameList(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(failureMessage);
    }

    private static Stream<Arguments> validateNameList_자동차_이름_검증에_실패한다() {
        return Stream.of(
            Arguments.of(List.of(""), InputValidation.CAR_NAME_LENGTH_VALIDATION_EXCEPTION),
            Arguments.of(List.of("     "), InputValidation.CAR_NAME_LENGTH_VALIDATION_EXCEPTION),
            Arguments.of(List.of("aaaabbbccccccdddeeee"), InputValidation.CAR_NAME_LENGTH_VALIDATION_EXCEPTION),
            Arguments.of(List.of("a", "a", "b"), InputValidation.CAR_SAME_NAME_EXCEPTION)
        );
    }
}

