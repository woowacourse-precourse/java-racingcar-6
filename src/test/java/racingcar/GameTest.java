package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void findWinningPosition_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        car1.move(); car1.move(); car1.move();  // position: 3
        car2.move(); car2.move();  // position: 2
        car3.move(); car3.move(); car3.move(); car3.move();  // position: 4

        int winningPosition = Game.findWinningPosition(cars);

        assertThat(winningPosition).isEqualTo(4);
    }

    @Test
    void findWinners_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        car1.move(); car1.move(); car1.move();  // position: 3
        car2.move(); car2.move();  // position: 2
        car3.move(); car3.move(); car3.move(); car3.move();  // position: 4

        List<String> winners = Game.findWinners(cars, 4);

        assertThat(winners).containsExactly("car3");
    }
}
