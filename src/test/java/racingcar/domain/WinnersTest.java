package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    public void testGetWinnerNames() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("yeon");
        car1.move(3);
        car2.move(5);
        List<Car> cars = Arrays.asList(car1, car2);
        Winners winners = new Winners(cars);
        List<String> winnerNames = winners.getWinnerNames();
        assertThat(winnerNames).containsExactly("yeon");
    }

}
