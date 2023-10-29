package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

class CarTest {

    @Test
    void 자동차_이름_길이_초과_예외발생() {
        // given
        String name="123456";

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.CAR_NAME_LENGTH_OVER_ERR_MESSAGE);
    }

    @Test
    void 자동차_이름_공백_예외발생() {
        // given
        String name="  ";

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.CAR_NAME_BLANK_ERR_MESSAGE);
    }

}