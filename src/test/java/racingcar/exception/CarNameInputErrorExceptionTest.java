package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.ThrowableAssert.catchThrowable;


class CarNameInputErrorExceptionTest {
    @Test
    void 자동차_이름이_한_글자_미만일_경우_예외_발생(){
        //given
        InputErrorException inputErrorException = new CarNameInputErrorException();
        String input = "";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_다섯_글자_초과할_경우_예외_발생(){
        //given
        InputErrorException inputErrorException = new CarNameInputErrorException();
        String input = "jjonghyuni";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}