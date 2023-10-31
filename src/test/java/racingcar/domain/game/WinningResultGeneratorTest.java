package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.random_generator.FakeRandomMove;
import racingcar.domain.game.WinningResultGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultGeneratorTest {

    List<Car> cars;
    WinningResultGenerator winningResultGenerator = new WinningResultGenerator();

    @BeforeEach
    void init() {
        String names = "a,b,c";
        Car car1 = new Car("a", new FakeRandomMove(4,9));
        Car car2 = new Car("b", new FakeRandomMove(0,3));
        Car car3 = new Car("c", new FakeRandomMove(4,9));
        cars = List.of(car1,car2,car3);

        for (Car car : cars) {
            car.moveCar();
        }
    }


    @Test
    void chooseWinningCarTest() {
        List<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("c");

        List<String> result =  winningResultGenerator.chooseWinningCars(cars);

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void generateWinnersTest() {
        String expected = "a, c";

        String result = winningResultGenerator.generateWinners(cars);

        assertThat(result)
                .isEqualTo(expected);
    }
}
