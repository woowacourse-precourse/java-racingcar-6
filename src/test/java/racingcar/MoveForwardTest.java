package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MoveForwardTest {

    @Test
    void 모든_자동차_1회_전진() {
        // given
        GameRule rule = new GameRule(5, 0, 9);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(rule, "Max"));
        cars.add(new Car(rule, "Lando"));
        cars.add(new Car(rule, "Lewis"));
        cars.add(new Car(rule, "Oscar"));
        cars.add(new Car(rule, "Alex"));
        cars.add(new Car(rule, "Sainz"));
        cars.add(new Car(rule, "Kevin"));
         MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        // when
        for (int i = 0; i < cars.size(); i++) {
            mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                    .thenReturn(i);
            cars.get(i).moveForward();
        }
        // then
        for (int i = 0; i < cars.size(); i++) {
            if (i < 4) {
                Assertions.assertThat(cars.get(i).getDistance()).isEqualTo(0);
            } else if (i >= 4) {
                Assertions.assertThat(cars.get(i).getDistance()).isEqualTo(i);
            }
        }
         mocked.close();
    }
}
