package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

public class NewRacingCarTest {
    List<Car> racingCarList = new ArrayList<>();
    class User {
        public String[] carNames() {
            return new String[] { "A", "B", "C"};
        }
    }
    @Test
    void addRacingCarTest() {
        // given
        User user = new User();
        // when
        String[] carNames = user.carNames();
        for (String carName : carNames) {
            racingCarList.add(new Car(carName));
        }
        // then
        Assertions.assertThat(racingCarList.size()).isEqualTo(3);

    }
}
