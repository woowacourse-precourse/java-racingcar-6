package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @DisplayName("차 위치가 같은지에 대해 테스트 True")
    @ParameterizedTest
    @ValueSource(ints = {1,4,9})
    void 차_이동_테스트 (int maxTryCount) {

        //given
        Car car = Car.createCar(new Name("test"));

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
    @Test
    void 차_이동_포지션_테스트_TRUE () {

        //given
        Car moveCar = Car.createCar(new Name("test"));
        moveCar.move();
        Car otherMoveCar = Car.createCar(new Name("other"));
        otherMoveCar.move();

        //then
        Assertions.assertThat(moveCar.isSamePosition(otherMoveCar)).isTrue();
    }

    @DisplayName("차 위치가 같은지에 대해 테스트 FALSE")
    @Test
    void 차_이동_포지션_테스트_FALSE () {

        //given
        Car moveCar = Car.createCar(new Name("test"));
        moveCar.move();
        Car notMovedCar = Car.createCar(new Name("other"));

        //then
        Assertions.assertThat(moveCar.isSamePosition(notMovedCar)).isFalse();
    }

}