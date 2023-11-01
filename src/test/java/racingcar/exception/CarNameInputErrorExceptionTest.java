package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.constant.ErrorMessageConstant;

class CarNameInputErrorExceptionTest {
    private final static InputErrorException inputErrorException = new CarNameInputErrorException();
    @Test
    void 자동차_이름이_한_글자_미만일_경우_예외_발생(){
        //given
        final String checkInput = ",jyuni";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.CAR_NAME_LENGTH_SHORT_MESSAGE.getMessage());
    }

    @Test
    void 자동차_이름이_다섯_글자_초과할_경우_예외_발생(){
        //given
        final String checkInput = "JJONGHYUNI";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.CAR_NAME_LENGTH_LONG_MESSAGE.getMessage());
    }

    @Test
    void 자동차_이름을_아무것도_입력_안했을_경우_예외_발생(){
        //given
        final String checkInput = "";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INPUT_EMPTY_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 자동차_이름에_중복된_값이_존재할_경우_예외_발생(){
        //given
        final String checkInput = "JJONG,JJONG";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.CAR_NAME_DUPLICATE_MESSAGE.getMessage());
    }
}