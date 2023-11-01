package racingcar;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @DisplayName("자동차 경주 게임의 최종 우승자를 산출할 수 있다")
    @Test
    void findWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        int[][] randomNumber = {{5, 5, 1}, {5, 5, 5}, {5, 5, 1}};
        for (int[] accel : randomNumber) {
            car1.move(accel[0]);
            car2.move(accel[1]);
            car3.move(accel[2]);
        }
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        List<String> winners = cars.findWinners();
        assertThat(winners).contains("pobi", "woni");
    }
}
