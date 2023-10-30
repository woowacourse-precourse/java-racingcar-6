package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InvalidInputTest {
    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

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

    @DisplayName("주어진 횟수가 숫자가 아니면 예외가 발생한다.")
    @Test
    void NotIntegerValueException(){
        //given
        InputView inputView = new InputView();
        systemIn("a");

        //when //then
        assertThatThrownBy(()-> inputView.inputTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 숫자 여야 합니다.");

    }

}