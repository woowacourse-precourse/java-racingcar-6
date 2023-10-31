package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class MainTest extends NsTest {
    @Test
    void 시도_횟수_문자열이면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("oh,kim", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_0이면_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("lee,park", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 우승자_맞게_출력() {
        List<Car> entry = Arrays.asList(new Car("yang"), new Car("han"), new Car("choi"));
        entry.get(0).distanceMoved = 10;
        entry.get(1).distanceMoved = 11;
        entry.get(2).distanceMoved = 9;
        List<String> winnerList = Application.announceWinner(entry);
        assertThat(winnerList).containsOnly("han");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}