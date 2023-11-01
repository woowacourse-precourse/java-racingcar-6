package jalddak.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void move(int num) {
        //given
        Car car = new Car("HJ");
        int expect = car.getDistance();
        if (num >= 4) {
            expect += 1;
        }
        //when
        car.move(num);
        assertThat(expect).isEqualTo(car.getDistance());
    }
}
