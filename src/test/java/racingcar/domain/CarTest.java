package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 생성 간, 5자 초과 이름으로 인해 예외가 발생한다.")
    @Test
    void checkNameLengthDuringCreateCar() {
        //given
        final String name = "bonsik";

        //when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}