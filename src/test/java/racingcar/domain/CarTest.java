package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @DisplayName("Car 생성 성공 테스트")
    @Test
    void createCarSuccessTest() {

        // given
        CarName carName = new CarName("김씨차");

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getCarName()).isEqualTo("김씨차");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car goForward 성공 테스트 - 전진")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void carGoForwardSuccessTest_1(int movableSymbol) {

        // given
        CarName carName = new CarName("김씨차");
        Car car = new Car(carName);

        // when
        car.move(movableSymbol);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("Car goForward 성공 테스트 - 제자리")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void carGoForwardSuccessTest_2(int movableSymbol) {

        // given
        CarName carName = new CarName("김씨차");
        Car car = new Car(carName);

        // when
        car.move(movableSymbol);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car goForward 실패 테스트")
    @ValueSource(ints = {-1, 10, 100, 5000, -100})
    @ParameterizedTest
    void carGoForwardFailTest(int movableSymbol) {

        // given
        CarName carName = new CarName("김씨차");
        Car car = new Car(carName);

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> car.move(movableSymbol));
    }

    @DisplayName("Car isEqualPosition 테스트 - 같은 위치")
    @Test
    void carIsEqualPositionSuccessTest_1() {

        // given
        CarName carName1 = new CarName("김씨차");
        CarName carName2 = new CarName("최씨차");

        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);

        // when
        // then
        assertThat(car1.isEqualPosition(car2)).isTrue();
    }

    @DisplayName("Car isEqualPosition 테스트 - 다른 위치")
    @Test
    void carIsEqualPositionSuccessTest_2() {

        // given
        CarName carName1 = new CarName("김씨차");
        CarName carName2 = new CarName("최씨차");

        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);

        car2.move(5);

        // when
        // then
        assertThat(car1.isEqualPosition(car2)).isFalse();
    }
}