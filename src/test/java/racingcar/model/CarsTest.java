package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 차량_이름_중복_검사_테스트() {
        List<Car> cars = List.of(new Car("abc"), new Car("abc"));

        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
