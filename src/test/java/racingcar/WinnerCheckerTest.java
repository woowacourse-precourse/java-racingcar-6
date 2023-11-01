package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerCheckerTest {

    private WinnerChecker winnerChecker = new WinnerChecker();

    @Test
    void 자동차들의_최종_위치가_모두_0인_경우_예외() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        List<Car> carList = List.of(pobi, woni);

        assertThatThrownBy(() -> winnerChecker.getWinnerList(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 중 이동한 자동차가 없습니다.");
    }

    @Test
    void 우승자를_정상적으로_반환하는가() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car moly = new Car("moly");
        List<Car> carList = List.of(pobi, woni, moly);

        woni.moveForward();
        moly.moveForward();

        assertThat(winnerChecker.getWinnerList(carList)).containsExactly("woni", "moly");
    }
}
