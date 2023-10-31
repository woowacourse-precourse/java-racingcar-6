package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.car.carName.HasSpaceException.HAS_SPACE_EXCEPTION_MESSAGE;
import static racingcar.exception.car.carName.LengthException.LENGTH_EXCEPTION_MESSAGE;
import static racingcar.exception.cars.DuplicateException.DUPLICATE_EXCEPTION_MESSAGE;
import static racingcar.exception.round.totalNumberOfRounds.NonPositiveIntegerException.NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE;

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
    @ValueSource(strings = {",2,3", "1,,3", "1,2,"})
    void 자동차_이름_빈_문자열_테스트(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,more_than_five", "1,2,abcdef", "1,2,123456", "1,2,아에이오우으", "1,2,!@#$%^"})
    void 자동차_이름_5자_이상인_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,a", "succ,ess,fuln,ess"})
    void 자동차_이름_중복이_있는_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,공 백", "a,b,태\t앱"})
    void 자동차_이름_공백문자_있는_경우(String carNames) {
        assertThatThrownBy(() -> CarNamesValidator.getInstance().validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAS_SPACE_EXCEPTION_MESSAGE);
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
