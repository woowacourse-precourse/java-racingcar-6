package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameRangeException;
import racingcar.model.number.InputNumberGenerator;

class CarTest {

    @Test
    void 자동차_이름이_5글자_초과시_예외_발생() {

        assertThatThrownBy(() -> Car.createCar("JWbase"))
                .isInstanceOf(CarNameRangeException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름이_공백이면_예외_발생() {

        assertThatThrownBy(() -> Car.createCar(" "))
                .isInstanceOf(BlankCarNameException.class)
                .hasMessage("자동차 이름을 입력하세요.");
    }

    @Test
    void 숫자가_4이상이면_앞으로_이동() {
        Car car = Car.createCar("car1");
        InputNumberGenerator generator = new InputNumberGenerator(4);
        car.moveForward(generator);
        car.moveForward(generator);

        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }
}