package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.constant.ErrorMessageConstant;

class TryCountInputErrorExceptionTest {
    private final static InputErrorException inputErrorException = new TryCountInputErrorException();

    @Test
    void 자동차_경주_시도_횟수_빈_값_입력_시_예외_발생(){
        //given
        final String checkInput = "";

        //when,then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INPUT_EMPTY_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 자동차_경주_시도_횟수_입력_값_숫자가_아닐_경우_예외_발생(){
        //given
        final String checkInput ="asd";

        //when,then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.TRY_INPUT_IS_NOT_NUMBER_MESSAGE.getMessage());
    }
}