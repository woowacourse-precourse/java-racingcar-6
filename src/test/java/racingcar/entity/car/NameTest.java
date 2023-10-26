package racingcar.entity.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.entity.constants.ErrorConstants.*;

class NameTest {

    @Test
    @DisplayName("자동차에 이름을 저장할 수 있다.")
    public void nameTest() {
        // given
        String carName = "myCar";
        // when
        Name name = new Name(carName);
        // then
        assertThat(name.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차에 이름이 5글자가 넘어가면 예외가 발생한다.")
    public void nameExceptionTest() {
        // given
        String carName = "haenCar";
        // when // then
        assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ERROR_MESSAGE);
    }

}