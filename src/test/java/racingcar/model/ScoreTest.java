package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @Test
    @DisplayName("제일 먼 거리에 있는 Car리스트 반환하는지 확인")
    public void findFarthestCar() {
        List<Car> racingCars = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(1);
        Car dobiCar = new Car("dobi");
        dobiCar.moveForward(5);
        racingCars.add(pobiCar);
        racingCars.add(dobiCar);

        Score score = new Score(1, racingCars);
        assertThat(score.findFarthestCar()).contains(dobiCar);
    }

}