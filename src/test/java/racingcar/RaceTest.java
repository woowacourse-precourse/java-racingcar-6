package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.CarUtil;
import racingcar.util.RaceUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void raceNumberTest() {
        String input = "5";
        int result = RaceUtil.raceNumber(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void raceTest() {
        String inputName = "pobi,woni";
        List<Car> cars = CarUtil.createCar(inputName);
        RaceUtil.race(cars);
        for (Car c : cars) {
            System.out.println(c.getPosition());
        }
    }
}
