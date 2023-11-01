package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TrialNumberValidator;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class ValidatorTest {

    @Test
    void 자동차이름_1글자미만_입력() {
        String carNames = "";
        assertThatThrownBy(() -> new CarNameValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_1글자미만_입력2() {
        String carNames = "tae,,yeon";
        assertThatThrownBy(() -> new TrialNumberValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_중복_입력() {

        String carNames = "tae,tae,yeon";
        assertThatThrownBy(() -> new CarNameValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5글자_초과() {

        String carNames = "taeyea,tea";
        assertThatThrownBy(() -> new CarNameValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_빈문자_입력() {
        String carNames = "tae, ,yeon";
        assertThatThrownBy(() -> new TrialNumberValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자_입력() {
        String number = "a";
        assertThatThrownBy(() -> new TrialNumberValidator(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_빈문자_입력() {
        String number = " ";
        assertThatThrownBy(() -> new TrialNumberValidator(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_1글자미만_입력() {
        String number = "";
        assertThatThrownBy(() -> new TrialNumberValidator(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0으로시작하는숫자_입력() {
        String number = "01";
        assertThatThrownBy(() -> new TrialNumberValidator(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0_입력() {
        String number = "0";
        assertThatThrownBy(() -> new TrialNumberValidator(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
