package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

@DisplayName("RacingCars 클래스 테스트")
class RacingCarsTest {
    @Test
    @DisplayName("입력받은 차의 갯수가 1개 이하면 IllegalArgumentException 을 발생시켜야한다.")
    void init_one_car_test() {
        String[] carsName = {"java"};
        Assertions.assertThatThrownBy(() -> new RacingCars(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 차의 갯수가 10개 이상이면 IllegalArgumentException 을 발생시켜야한다.")
    void init_over_six_car_test() {
        String[] carsName = {"java1", "java2", "java3", "java4", "java5", "java6", "java7", "java8", "java9", "java0"};
        Assertions.assertThatThrownBy(() -> new RacingCars(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 차의 이름이 중복이면 IllegalArgumentException 을 발생시켜야한다.")
    void init_duplicate_test() {
        String[] carsName = {"java1", "java1"};
        Assertions.assertThatThrownBy(() -> new RacingCars(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫번째 차가 전진을 하고 두번째 차가 멈춰있을 때, 전진한 첫번째 차가 우승자가 되어야한다.")
    void getWinner() {
        String[] carsName = {"java", "java1"};
        int moveForward = 4;
        int stop = 0;

        RacingCars racingCars = new RacingCars(carsName);

        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.move();
                    Assertions.assertThat(racingCars.getWinner()).isEqualTo(List.of(carsName[0]));
                },
                moveForward, stop
        );
    }

    @Test
    @DisplayName("첫번째 차와 두번째 차가 모두 전진하면, 모든 차가 우승자가 되어야한다.")
    void getWinners() {
        String[] carsName = {"java", "java1"};
        int moveForward = 6;

        RacingCars racingCars = new RacingCars(carsName);

        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.move();
                    Assertions.assertThat(racingCars.getWinner()).isEqualTo(List.of(carsName));
                },
                moveForward
        );
    }
}
