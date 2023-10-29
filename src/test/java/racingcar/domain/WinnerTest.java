package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerTest {

    @Test
    void 우승자_판별_검증() {
        Car car1 = new Car("win");
        Car car2 = new Car("test");
        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);

        car1.moveForward();

        Winner winner = new Winner(1);

        winner.judgeRacingWinner(carList);

        String result = winner.getWinners();

        assertThat(result).isEqualTo("win");
    }

    @Test
    void 우승자_2명_이상_출력() {
        Car car1 = new Car("test");
        Car car2 = new Car("win");
        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);

        car1.moveForward();
        car2.moveForward();

        Winner winner = new Winner(1);

        winner.judgeRacingWinner(carList);

        String result = winner.getWinners();

        assertThat(result).isEqualTo("test, win");
    }
}