package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CarNameInputErrorExceptionTest {
    InputErrorException inputErrorException = new CarNameInputErrorException();
    @Test
    void 자동차_이름이_한_글자_미만일_경우_예외_발생(){
        //given
        List<String> checkInputList = List.of("");

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_다섯_글자_초과할_경우_예외_발생(){
        //given
        List<String> checkInputList = List.of("JJONGHYUNI");

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름을_아무것도_입력_안했을_경우_예외_발생(){
        //given
        List<String> checkInputList = new ArrayList<>(Collections.emptyList());

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_중복된_값이_존재할_경우_예외_발생(){
        //given
        List<String> checkInputList = Arrays.asList("JJONGHYUNI","JJONGHYUNI");

        //when, then
        Assertions.assertThatThrownBy(() -> inputErrorException.checkUserInputValidate(checkInputList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}