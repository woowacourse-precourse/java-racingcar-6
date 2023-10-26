package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TryCountInputErrorExceptionTest {
    private final static InputErrorException inputErrorException = new TryCountInputErrorException();
    private final static String TRY_INPUT_IS_EMPTY_MESSAGE = "값을 입력해주세요. 게임을 종료합니다.";
    private final static String TRY_INPUT_IS_NOT_NUMBER_MESSAGE = "숫자만 입력이 가능합니다. 게임을 종료합니다.";
    @Test
    void 자동차_경주_시도_횟수_빈_값_입력_시_예외_발생(){
        //given
        final String checkInput = "";

        //when,then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(TRY_INPUT_IS_EMPTY_MESSAGE);
    }

    @Test
    void 자동차_경주_시도_횟수_입력_값_숫자가_아닐_경우_예외_발생(){
        //given
        final String checkInput ="asd";

        //when,then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(TRY_INPUT_IS_NOT_NUMBER_MESSAGE);
    }
}