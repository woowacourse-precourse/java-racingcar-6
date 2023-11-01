package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.StaticRacingCar.eachRoundResult;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.StaticRacingCar.NumberGenerator;
import racingcar.StaticRacingCar.User;
import racingcar.car.Car;

public class NewRacingCarTest {
    static List<Car> racingCarList;

    @BeforeEach
    void setUp() {
        racingCarList = new ArrayList<>();
    }


    private static void initializeCars() {
        String[] carNames = User.carNames();
        for (String carName : carNames) {
            racingCarList.add(new Car(carName));
        }
    }

    @Test
    void addRacingCarTest() {
        //given
        initializeCars();
        // when, then
        assertThat(racingCarList.size()).isEqualTo(3);
    }

    @Test
    void racingRoundTest() {
        // when
        initializeCars();
        // then
        assertThat(User.racingRound()).isEqualTo("3");
    }

    @Test
    void runOneRoundTest() {
        // given
        initializeCars();

        // when, then
        for (Car car : racingCarList) {
            car.move(NumberGenerator.generateNumber());
        }

        for (Car car : racingCarList) {
            assertThat(car.getCurrentPosition()).isEqualTo(1);
        }
    }
    @Test
    void printEachRoundResult() {
        // given
        initializeCars();

        // when
        for (Car car : racingCarList) {
            car.move(NumberGenerator.generateNumber());
        }
        String result = eachRoundResult(racingCarList);

        // then
        String expectedOutputResult =
                "A : -" + "\n" +
                "B : -" + "\n"
                + "C : -" + "\n";
        assertThat(result).isEqualTo(expectedOutputResult);
    }
}

