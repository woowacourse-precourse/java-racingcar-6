package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {


    @ParameterizedTest
    @ValueSource(strings = {"a", "pobi", "a2", "abcd", "1234", "  abc   ",})
    void CarNameSuccessTest(String name) {
        Car car = new Car(name);

        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void CarNameFailTest() {

    }
}
