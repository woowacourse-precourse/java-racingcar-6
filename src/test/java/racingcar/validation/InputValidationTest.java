package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidationTest {

    @Test
    void validateName_자동차_이름을_검증_성공한다() {
        // given : 테스트를 진행하기 위해 필요한 값 세팅 및 설정
        String carName = "pobi";

        // when : 언제? 테스트 대상 메서드 실행
        // then : 실질적으로 검증하는 과정
        assertDoesNotThrow(() -> InputValidation.validateName(carName));
    }

    @ParameterizedTest
    @MethodSource("validationName_자동차_이름을_검증_실패한다")
    void validateName_자동차_이름을_검증_실패한다(String carName) {
        assertThatThrownBy(() -> InputValidation.validateName(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.CAR_NAME_LENGTH_VALIDATION_EXCEPTION);
    }

    private static Stream<Arguments> validateName_자동차_이름을_검증_실패한다() {
        return Stream.of(
            Arguments.of("     "),
            Arguments.of(""),
            Arguments.of("abcdefghijkl")
        );
    }

    @Test
    void validateNameAndSplit_자동차_콤마구분_검증_성공한다() {
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
    void validateDuplicatedName_자동차_이름이_다를경우_성공한다() {
        List<String> carNames = List.of("pobi", "crong");
        assertThat(carNames).contains("pobi", "crong");
        assertDoesNotThrow(() -> InputValidation.validateDuplicatedName(carNames));
    }

    @ParameterizedTest
    @MethodSource("validateDuplicatedName_자동차_이름이_같을경우_실패한다")
    void validateDuplicateName_자동차_이름이_같을경우_실패한다(List<String> carNames) {
        assertThatThrownBy(() -> InputValidation.validateDuplicatedName(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputValidation.CAR_SAME_NAME_EXCEPTION);
    }

    private static Stream<Arguments> validateDuplicatedName_자동차_이름이_같을경우_실패한다() {
        return Stream.of(
            Arguments.of(Arrays.asList("pobi", "pobi")),
            Arguments.of(Arrays.asList("crong", "crong")),
            Arguments.of(Arrays.asList("a", "a"))
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
}

