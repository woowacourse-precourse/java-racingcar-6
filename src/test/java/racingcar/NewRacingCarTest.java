package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

public class NewRacingCarTest {
    List<Car> racingCarList;

    @BeforeEach
    void setUp() {
        racingCarList = new ArrayList<>();
    }


    static class User {
        public static String[] carNames() {
            return new String[]{"A", "B", "C"};
        }

        public static String racingRound() {
            return "3";
        }
    }

    static class NumberGenerator {
        public static int generateNumber() {
            return 4;
        }
    }


    @Test
    void addRacingCarTest() {
        // when
        String[] carNames = User.carNames();
        for (String carName : carNames) {
            racingCarList.add(new Car(carName));
        }
        // then
        assertThat(racingCarList.size()).isEqualTo(3);
    }

    @Test
    void racingRoundTest() {
        // when
        String racingRound = User.racingRound();
        // then
        assertThat(racingRound).isEqualTo("3");
    }

    @Test
    void runRaceTest() {
        // given
        String[] carNames = User.carNames();
        for (String carName : carNames) {
            racingCarList.add(new Car(carName));
        }
        // when, then
        for (Car car : racingCarList) {
            car.move(NumberGenerator.generateNumber());
        }

        for (Car car : racingCarList) {
            assertThat(car.getCurrentPosition()).isEqualTo(1);
        }
    }

}

