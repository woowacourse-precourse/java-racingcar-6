package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @DisplayName("차 위치가 같은지에 대해 테스트 True")
    @ParameterizedTest
    @ValueSource(ints = {1,4,9})
    void 차_이동_테스트 (int maxTryCount) {

        //given
        Car car = Car.createCar(new Name("test"), 0);

        //when
        int currentTryCount = 0;
        while (currentTryCount < maxTryCount) {
            car.move();
            currentTryCount++;
        }

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(maxTryCount);
    }
    @DisplayName("차 위치가 같은지에 대해 테스트 True")
    @ParameterizedTest
    @CsvSource(value = {"1,3", "5,1", "10,5"})
    void 차_이동_포지션_테스트_TRUE (int position, int otherPosition) {

        //given
        Car car = Car.createCar(new Name("test"), position);
        Car otherCar = Car.createCar(new Name("other"), otherPosition);

        //then
        Assertions.assertThat(car.isSamePosition(otherCar)).isTrue();
    }

    @DisplayName("차 위치가 같은지에 대해 테스트 FALSE")
    @ParameterizedTest
    @CsvSource(value = {"1,3", "5,1", "10,5"})
    void 차_이동_포지션_테스트_FALSE (int position, int otherPosition) {

        //given
        Car car = Car.createCar(new Name("test"), position);
        Car otherCar = Car.createCar(new Name("other"), otherPosition);

        //then
        Assertions.assertThat(car.isSamePosition(otherCar)).isFalse();
    }

}