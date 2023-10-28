package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    Car car = new Car("Null");

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    void 전진하는_조건은_0에서_9사이에서_값을_구한_후_무작위_값이_4_이상(int randomValue) {
        car.move(randomValue);
        if (randomValue >= 4) {
            Assertions.assertThat("Null : -").isEqualTo(car.toString());
        } else {
            Assertions.assertThat("Null : ").isEqualTo(car.toString());
        }
    }
}
