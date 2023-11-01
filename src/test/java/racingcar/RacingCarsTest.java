package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}