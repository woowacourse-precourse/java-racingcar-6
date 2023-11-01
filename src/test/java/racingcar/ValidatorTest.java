package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

class ValidatorTest {
    final Validator validator = Validator.getInstance();

    @Test
    @DisplayName("예외 - 자동차 이름을 입력하지 않는다.")
    void test1() {
        //given
        final String name = "";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.carNames(name));
    }

    @Test
    @DisplayName("예외 - 자동차 이름을 하나만 입력한다.")
    void test2() {
        //given
        final String name = "고민석";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.carNames(name));
    }

    @Test
    @DisplayName("예외 - 시도 횟수 입력을 하지 않는다.")
    void test3() {
        //given
        final String playTimes = "";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.playTimes(playTimes));
    }

    @Test
    @DisplayName("예외 - 시도 횟수를 숫자가 아닌 다른 문자열을 입력한다.")
    void test4() {
        //given
        final String playTimes = "a";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.playTimes(playTimes));
    }
}
