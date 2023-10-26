package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameInputErrorExceptionTest {
    InputErrorException inputErrorException = new CarNameInputErrorException();
    private final static String CAR_NAME_LENGTH_SHORT_MESSAGE = "각 자동차 이름은 1글자 이상 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_LENGTH_LONG_MESSAGE = "각 자동차 이름은 5글자 이하로 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_LIST_EMPTY_MESSAGE = "자동차 이름은 필수로 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_DUPLICATE_MESSAGE = "중복된 자동차 이름이 존재합니다. 게임을 종료합니다.";
    @Test
    void 자동차_이름이_한_글자_미만일_경우_예외_발생(){
        //given
        String checkInput = ",jjonghyuni";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(CAR_NAME_LENGTH_SHORT_MESSAGE);
    }

    @Test
    void 자동차_이름이_다섯_글자_초과할_경우_예외_발생(){
        //given
        String checkInput = "JJONGHYUNI";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(CAR_NAME_LENGTH_LONG_MESSAGE);
    }

    @Test
    void 자동차_이름을_아무것도_입력_안했을_경우_예외_발생(){
        //given
        String checkInput = "";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(CAR_NAME_LIST_EMPTY_MESSAGE);
    }

    @Test
    void 자동차_이름에_중복된_값이_존재할_경우_예외_발생(){
        //given
        String checkInput = "JJONG,JJONG";

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(CAR_NAME_DUPLICATE_MESSAGE);
    }
}