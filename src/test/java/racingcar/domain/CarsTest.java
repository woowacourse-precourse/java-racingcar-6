package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;
    private List<Car> actual;

    @BeforeEach
    void initTest() {
        actual = Arrays.asList(new Car("pobi"), new Car("jiho"), new Car("java"));
        cars = new Cars(actual);
    }

    @Test
    void 우승자_한명인_경우() {
        actual.get(0).moveForward();
        actual.get(0).moveForward();
        actual.get(0).moveForward();
        List<Car> expected = Arrays.asList(actual.get(0));

        Assertions.assertThat(cars.compareWinner()).isEqualTo(expected);
    }

    @Test
    void 우승자_두명인_경우() {
        actual.get(0).moveForward();
        actual.get(0).moveForward();
        actual.get(1).moveForward();
        actual.get(1).moveForward();
        List<Car> expected = Arrays.asList(actual.get(0), actual.get(1));

        Assertions.assertThat(cars.compareWinner()).isEqualTo(expected);
    }
}
