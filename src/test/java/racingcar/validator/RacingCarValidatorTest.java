package racingcar.validator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarValidatorTest {

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxxx",
            "pobiiiiiiiiii,crong,honux",
            "thelongestnameintheword"})
    void 자동차_이름_5글자_체크_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.racingCarNameLengthValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi,wendi",
            "juni,crong,juni",
            "jun,hun,hun"})
    void 자동차_이름_중복_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.racingCarNameDuplicationValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi,cro ng,hon x",
            "po d,crong,honux",
            "th d"})
    void 자동차_이름_공백_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.racingCarNameInputContainsSpaceValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"",
            "",
            ""})
    void 자동차_이름_빈문자_입력_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.racingCarNameEmptyInputValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"",
            "",
            ""})
    void 숫자_빈문자_입력_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.numberAttemptsEmptyInputValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"f",
            "bfb",
            "e"})
    void 숫자_입력_체크_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.numberAttemptsInputOnlyNumberValidator(input)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"0",
            "-1",
            "-10"})
    void 숫자_최솟값_입력_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                RacingCarValidator.numberAttemptsInputMinValueValidator(input)
        );
    }
}
