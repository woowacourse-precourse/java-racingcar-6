package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarNameInputErrorExceptionTest {
    @Test
    void 자동차_이름이_한_글자_미만일_경우_예외_발생(){
        //given
        InputErrorException inputErrorException = new CarNameInputErrorException();
        List<String> checkInputList = List.of("");

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_다섯_글자_초과할_경우_예외_발생(){
        //given
        InputErrorException inputErrorException = new CarNameInputErrorException();
        List<String> checkInputList = List.of("JJONGHYUNI");

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}