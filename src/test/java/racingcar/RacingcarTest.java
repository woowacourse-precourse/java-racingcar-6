package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingcarTest {

    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    public void testNameLength() {
        assertThatThrownBy(
                () -> {
                    InputView.toCarNames("a,b,cdefgh");
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("시도 횟수에 숫자가 아닌 값을 입력하는 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    public void testTryNumberFormat() {
        assertThatThrownBy(
                () -> {
                    InputView.tryNumber("a");
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("시도 횟수에 음수 값을 입력하는 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    public void testTryNumberUnder0() {
        assertThatThrownBy(
                () -> {
                    InputView.tryNumber("-4");
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }


}

