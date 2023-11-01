package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void playRound() {
    }

    @Test
    void findWinners_메서드가_올바른_우승자를_반환() {
        Cars cars = new Cars("na,yoon,kang");
        List<Car> carList = cars.toList();
        carList.get(0).moveOrNot(MOVING_FORWARD);
        carList.get(1).moveOrNot(STOP);
        carList.get(2).moveOrNot(MOVING_FORWARD);
        assertThat(cars.findWinners()).containsExactly("na", "kang");
    }
}