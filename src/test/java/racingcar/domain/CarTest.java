package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> new Car(name, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름과 총 전진 횟수를 출력 포멧에 맞춰 출력 문자열을 생성한다.")
    @Test
    void resultMessage() {
        //given
        final String resultMessage = "bonsi : -----";
        Car car = new Car("bonsi", 5);

        //when
        String message = car.resultMessage();

        //then
        assertThat(message).isEqualTo(resultMessage);
    }

}