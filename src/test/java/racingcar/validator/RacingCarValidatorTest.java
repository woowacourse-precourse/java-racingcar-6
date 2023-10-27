package racingcar.validator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarValidatorTest {
    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    @Test
    void 자동차_이름_5글자_체크_테스트() {
        String racingCars = "pobi,huni,junbin";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.racingCarNameLengthValidator(racingCars))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_중복_테스트() {
        String racingCars = "pobi,huni,pobi";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.racingCarNameDuplicationValidator(racingCars))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_공백_테스트() {
        String racingCars = "pobi,hun i,p obi";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.racingCarNameInputContainsSpaceValidator(racingCars))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_빈문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.racingCarNameEmptyInputValidator(""))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자_빈문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.attemptNumberEmptyInputValidator(""))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자_입력_체크_테스트() {
        String number = "f";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        racingCarValidator.attemptInputOnlyNumberValidator(number))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}
