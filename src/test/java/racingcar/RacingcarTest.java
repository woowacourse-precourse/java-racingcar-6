package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @DisplayName("우승자 출력 포맷을 확인한다. 우승자는 한명 일수도 있고 여러명 일 수도 있다.")
    @Test
    public void testWinnerPrintFormat() {
        List<String> winnerSingle = List.of("a");
        assertThat(OutputView.winnerPrintFormat(winnerSingle)).isEqualTo("최종 우승자 : a");

        List<String> winnerMultiple = List.of("a", "b", "c");
        assertThat(OutputView.winnerPrintFormat(winnerMultiple)).isEqualTo("최종 우승자 : a, b, c");
    }
}