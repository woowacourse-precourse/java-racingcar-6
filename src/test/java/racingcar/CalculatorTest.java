package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {

    @Test
    void maxMove_계산() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.add(new Car("b"));

        cars.get(0).moveOrStop(true);
        cars.get(1).moveOrStop(false);

        int max = Calculator.MaxMove(cars);
        Assertions.assertThat(max).isEqualTo(1);
    }
}
