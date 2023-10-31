package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RefereeTest {

    private Referee referee = new Referee();

    @Test
    @DisplayName("모든 자동차의 이동 거리 저장")
    void 이동_거리_저장() {
        List<Car> racingCars = new ArrayList<>();

        Car car1 = new Car("car1");
        car1.plusDistance();
        racingCars.add(car1);

        Car car2 = new Car("car2");
        car2.plusDistance();
        car2.plusDistance();
        racingCars.add(car2);

        List<Integer> check = new ArrayList<>(Arrays.asList(1, 2));
        Assertions.assertThat(referee.saveAllDistances(racingCars)).isEqualTo(check);
    }

}