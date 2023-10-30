package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameRangeException;

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
}