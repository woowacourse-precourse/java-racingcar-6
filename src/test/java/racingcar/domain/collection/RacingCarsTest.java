package racingcar.domain.collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("우승자가 한명일 때 승리 출력로직 검사")
    void test_RacingOneWinner() {
        RacingCar carA = new RacingCar("A", 5);
        RacingCar carB = new RacingCar("B", 3);
        RacingCar carC = new RacingCar("C", 4);

        List<RacingCar> cars = Arrays.asList(carA, carB, carC);

        RacingCars racingCars = new RacingCars(cars);
        String resultString = racingCars.showResult();

        Assertions.assertThat(resultString)
                .contains("A");
    }

    @Test
    @DisplayName("우승자가 여럿일 때 승리 출력로직 검사")
    void test_RacingMultipleWinner() {
        RacingCar carA = new RacingCar("A", 5);
        RacingCar carB = new RacingCar("B", 3);
        RacingCar carC = new RacingCar("C", 4);
        RacingCar carD = new RacingCar("D", 5);
        RacingCar carE = new RacingCar("E", 5);

        List<RacingCar> cars = Arrays.asList(carA, carB, carC, carD, carE);
        RacingCars racingCars = new RacingCars(cars);
        String resultString = racingCars.showResult();
        Assertions.assertThat(resultString)
                .contains("A", "D", "E");
    }

}