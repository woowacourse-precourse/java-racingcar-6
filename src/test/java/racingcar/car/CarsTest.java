package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("우승자 찾기")
    void test1() {
        Car car1 = new Car("asdf");
        Car car2 = new Car("sdg");
        Car car3 = new Car("dfgh");

        car1.canMove(7);
        car1.canMove(7);
        car3.canMove(7);
        car3.canMove(7);

        Cars cars = new Cars();
        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        List<String> gameWinner = cars.getGameWinner();

        assertThat(gameWinner).isEqualTo(List.of("asdf", "dfgh"));
    }
}
