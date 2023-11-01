package racingcar.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class ResultTest {

    @Test
    void getNames() {
        Result result = new Result();
        for (int i = 1; i <= 10; i++) {
            RacingCar car = new RacingCar("car " + i);
            result.add(car);
        }
        List<String> names = result.getNames();
        for (int i = 1; i <= names.size(); i++) {
            assertThat(names.get(i - 1)).isEqualTo("car " + i);
        }
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinners() {
        Result result = new Result();
        for (int i = 1; i <= 10; i++) {
            RacingCar car = new RacingCar("car " + i);
            if (i == 2 || i == 5) {
                car.move();
            }
            result.add(car);
        }

        List<String> names = result.findWinners().getNames();
        assertThat(names.get(0)).isEqualTo("car 2");
        assertThat(names.get(1)).isEqualTo("car 5");
    }
}