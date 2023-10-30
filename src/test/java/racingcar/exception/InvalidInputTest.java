package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InvalidInputTest {

    @DisplayName("자동차 이름이 6글자 이상이면 예외가 발생한다.")
    @Test
    void longNameException(){
        //given
        InputView inputView = new InputView();
        String names = "hellow";

        //when //then
        assertThatThrownBy(() -> inputView.splitNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자 입니다.");
    }

    @DisplayName("")
    @Test
    void NotIntegerValueException(){
        //given

        //when

        //then
    }

}