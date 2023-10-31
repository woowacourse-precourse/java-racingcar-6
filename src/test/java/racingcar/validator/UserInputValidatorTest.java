package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.car.name.HasBlankException.HAS_BLANK_EXCEPTION_MESSAGE;
import static racingcar.exception.car.name.LengthException.LENGTH_EXCEPTION_MESSAGE;
import static racingcar.exception.cars.DuplicateException.DUPLICATE_EXCEPTION_MESSAGE;
import static racingcar.exception.round.NonPositiveIntegerException.NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.userInput.CarNamesValidator;
import racingcar.validator.userInput.TotalNumberOfRoundsValidator;

public class UserInputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_올바른_입력_테스트(String carNames) {
        assertThatCode(() -> CarNamesValidator.getInstance().validate(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,", ",2,3", "1,,3", "more_than_five,1,2", "1,2,abcdef", "1,2,123456", "1,2,아에이오우으"})
    void 자동차_이름_1자_이상_5자_이하가_아닌_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"succ,ess,ful,ess", "ba,na,na"})
    void 자동차_이름_중복이_있는_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"공 백,b,c", "태\t앱,b,c", "개\n행,b,c"})
    void 자동차_이름_공백이_있는_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAS_BLANK_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "55", "101"})
    void 라운드수_올바른_입력_테스트(String numberOfRounds) {
        assertThatCode(() -> TotalNumberOfRoundsValidator.getInstance().validate(numberOfRounds))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "#$", "_12", "001", "하위", "aa"})
    void 라운드수_양수가_아닌_경우(String numberOfRounds) {
        assertThatThrownBy(() -> TotalNumberOfRoundsValidator.getInstance().validate(numberOfRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
    }
}
