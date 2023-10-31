package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    public void Spilt() {
        String name = "가나,다라,마바";
        String cars = inputValidator.cars(name);
        Assertions.assertThat(cars).isEqualTo("가나,다라,마바");

    }

    @Test
    public void 너무_긴_이름() {

        String name = "이이름은다섯글자가넘어,다른이름";
        Assertions.assertThatThrownBy(() -> inputValidator.cars(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 시작이_공백인_이름() {

        String name = " nav,ddff";
        Assertions.assertThatThrownBy(() -> inputValidator.cars(name))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    public void 공백인_이름() {

        String name = " ,ddff";
        Assertions.assertThatThrownBy(() -> inputValidator.cars(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 숫자대신문자입력() {
        String number = "가나다";
        Assertions.assertThatThrownBy(() -> inputValidator.number(number))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    public void 음수입력() {
        String number = "-4";
        Assertions.assertThatThrownBy(() -> inputValidator.number(number))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    public void 값_0_입력() {
        String number = "0";
        Assertions.assertThatThrownBy(() -> inputValidator.number(number))
                .isInstanceOf(IllegalArgumentException.class);

    }







}