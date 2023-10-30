package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Random;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 충족X")
    void car_전진조건_충족테스트_충족X(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("전진 조건을 올바르게 판단하는가? - 충족O")
    void car_전진조건_충족테스트_충족O(int number) {
        assertThat(Random.isConditionsAdvancementMet(number)).isTrue();
    }

    @Test
    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있는가?")
    void car_자동차_전진_테스트() {
        Cars cars = new Cars();
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("java", 0);
        cars.addCar(car1);
        cars.addCar(car2);

        assertThat(cars.forwardCondition(car1, 5)).isEqualTo(1);
        assertThat(cars.forwardCondition(car2, 1)).isEqualTo(0);
    }
}
