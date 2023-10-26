package racingcar.entity.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 객체를 생성할 수 있다.")
    public void carTest() {
        // given
        String name = "myCar";
        // when
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getMoveCount()).isZero();
    }

    @DisplayName("입력값이 4 이상이면 하나 증가한다.")
    @ParameterizedTest(name ="{0}를 입력시 자동차가 한칸 움직인다.")
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveCar(int controlValue) {
        // given
        Car car = createCar();
        // when
        car.controlMovement(controlValue);
        // then
        Assertions.assertThat(car.getMoveCount()).isOne();
    }

    @DisplayName("입력값이 4 미만이면 증가하지 않는다.")
    @ParameterizedTest(name ="{0}를 입력시 자동차가 움직이지 않는다.")
    @ValueSource(ints = {0,1,2,3})
    public void stopCar(int controlValue) {
        // given
        Car car = createCar();
        // when
        car.controlMovement(controlValue);
        // then
        Assertions.assertThat(car.getMoveCount()).isZero();
    }

    private Car createCar(){
        String name = "myCar";
        return new Car(name);
    }

}