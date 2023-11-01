package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Domain.Cars;

public class CarsTest {

    private Car c1;
    private Car c2;

    @BeforeEach
    void testInit() {
        c1 = new Car("mason");
        c2 = new Car("mark");

        c1.moveForward(5);
        c1.moveForward(5);
        c1.moveForward(5);
        c1.moveForward(3);
        c2.moveForward(5);
    }

    @Test
    @DisplayName("경주 단일 우승자 테스트")
    void checkFindWinner() {
        Cars cars = new Cars(Arrays.asList(c1, c2));
        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(c1);
    }

    @Test
    @DisplayName("경주 다중 우승자 테스트")
    void checkFindWinners() {
        Car c3 = new Car("morty");

        c3.moveForward(5);
        c3.moveForward(5);
        c3.moveForward(5);

        Cars cars = new Cars(Arrays.asList(c1, c2, c3));

        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(c1, c3);
    }
}
