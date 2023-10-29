package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.car.name.LengthException.LengthExceptionMessage;
import static racingcar.exception.cars.DuplicateException.DuplicateExceptionMessage;
import static racingcar.exception.round.NonPositiveIntegerException.NonPositiveIntegerExceptionMessage;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_올바른_입력_테스트(String carNames) {
        assertThatCode(() -> InputValidator.validateCarList(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,", ",2,3", "1,,3", "more_than_five,1,2", "1,2,abcdef", "1,2,123456", "1,2,아에이오우으"})
    void 자동차_이름_1자_이상_5자_이하가_아닌_경우(String carNames) {
        assertThatThrownBy(() -> InputValidator.validateCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LengthExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"succ,ess,ful,ess", "ba,na,na"})
    void 자동차_이름_중복이_있는_경우(String carNames) {
        assertThatThrownBy(() -> InputValidator.validateCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DuplicateExceptionMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "55", "101"})
    void 라운드수_올바른_입력_테스트(String numberOfRounds) {
        assertThatCode(() -> InputValidator.validateNumberOfRounds(numberOfRounds))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "#$", "_12", "001", "하위", "aa"})
    void 라운드수_양수가_아닌_경우(String numberOfRounds) {
        assertThatThrownBy(() -> InputValidator.validateNumberOfRounds(numberOfRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NonPositiveIntegerExceptionMessage);
    }
}
