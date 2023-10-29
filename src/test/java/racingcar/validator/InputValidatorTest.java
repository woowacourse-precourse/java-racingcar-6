package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class ValidatorTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_정상_테스트(String carNames) {
        assertThatCode(() -> InputValidator.validateCarList(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,", ",2,3", "1,,3", "more_than_five,1,2", "1,2,abcdef", "1,2,123456", "1,2,아에이오우으"})
    void 자동차_이름_1자_이상_5자_이하가_아닌_경우(String carNames) {
        assertThatThrownBy(() -> InputValidator.validateCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하");
    }

    @ParameterizedTest
    @ValueSource(strings = {"succ,ess,ful,ess"})
    void 자동차_이름_중복이_있는_경우(String carNames) {
        assertThatThrownBy(() -> InputValidator.validateCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "55", "101"})
    void 사용자_입력_라운드수_정상_테스트(String numberOfRounds) {
        assertThatCode(() -> InputValidator.validateNumberOfRounds(numberOfRounds))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "#$", "_12", "001", "하위", "aa"})
    void 사용자_입력_라운드수_양수가_아닌_경우(String numberOfRounds) {
        assertThatThrownBy(() -> InputValidator.validateNumberOfRounds(numberOfRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수를 입력하지 않았습니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
