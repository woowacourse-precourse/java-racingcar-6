package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[CarTest]")
public class CarTest {
    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        // Given
        String carName = "pobi";
        int defaultDistance = 0;

        // When
        Car car = new Car(carName);

        // Then
        assertThat(carName).isEqualTo(car.getName());
        assertThat(defaultDistance).isEqualTo(car.getDistance());
    }

    @Test
    @DisplayName("무작위 숫자에 대한 자동차 이동 테스트 - 4 미만일 때")
    void canIMoveTest_UnderFour() {
        // Given
        Car car = new Car("sieun");
        int randomNumber = 1;

        // When
        car.canIMove(randomNumber);

        // Then
        assertThat(0).isEqualTo(car.getDistance());
    }

    @Test
    @DisplayName("무작위 숫자에 대한 자동차 이동 테스트 - 4 이상일 때")
    void canIMoveTest_OverFour() {
        // Given
        Car car = new Car("sieun");
        int randomNumber = 4;

        // When
        car.canIMove(randomNumber);

        // Then
        assertThat(1).isEqualTo(car.getDistance());
    }

    @Test
    @DisplayName("최대 이동거리 테스트 - 최대 이동거리가 맞을 경우")
    void findMaxDistanceTest_True() {
        // Given
        int inputMax = 1;
        Car car = new Car("sieun");
        car.canIMove(4);
        car.canIMove(4);

        // When
        int max = car.findMaxDistance(inputMax);

        // Then
        assertThat(inputMax).isLessThan(max);
    }

    @Test
    @DisplayName("최대 이동거리 테스트 - 최대 이동거리가 아닐 경우")
    void findMaxDistanceTest_False() {
        // Given
        int inputMax = 3;
        Car car = new Car("sieun");
        car.canIMove(4);

        // When
        int max = car.findMaxDistance(inputMax);

        // Then
        assertThat(inputMax).isEqualTo(max);
    }

    @Test
    @DisplayName("최대 이동거리와 같은지에 대한 테스트 - 같을 때")
    void isSameDistanceTest_SameDistance() {
        // Given
        int max = 1;
        Car car = new Car("sieun");
        car.canIMove(4);

        // When
        boolean isSameDistanceResult = car.isSameDistance(max);

        // Then
        assertThat(isSameDistanceResult).isTrue();
    }

    @Test
    @DisplayName("최대 이동거리와 같은지에 대한 테스트 - 같지 않을 때")
    void isSameDistanceTest_DifferentDistance() {
        // Given
        int max = 1;
        Car car = new Car("sieun");

        // When
        boolean isSameDistanceResult = car.isSameDistance(max);

        // Then
        assertThat(isSameDistanceResult).isFalse();
    }
}
