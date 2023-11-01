package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.WinnerDecider;

public class WinnerDeciderTest {
    @Test
    void 우승_자동차_결정() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));

        carList.get(0).setDistance(5);
        carList.get(1).setDistance(9);
        carList.get(2).setDistance(9);

        // when
        WinnerDecider winnerDecider = new WinnerDecider();
        List<String> winnerList = winnerDecider.getWinners(carList);

        // then
        assertThat(winnerList.size()).isEqualTo(2);
        assertTrue(winnerList.contains("Car2"));
        assertFalse(winnerList.contains("Car1"));
        assertTrue(winnerList.contains("Car3"));
    }
}
