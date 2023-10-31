package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InvalidInputTest {

    @AfterEach
    void closeConsole() {
        Console.close();
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

    @DisplayName("자동차 이름이 중복된 경우 예외가 발생한다.")
    @Test
    void DuplicateNameException(){
        //given
        InputView inputView = new InputView();
        String names = "haha,papa,haha";

        //when //then
        assertThatThrownBy(() -> inputView.splitNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 사용할 수 없습니다.");
    }

    @DisplayName("주어진 횟수가 숫자가 아니면 예외가 발생한다.")
    @Test
    void NotIntegerValueException(){
        //given
        InputView inputView = new InputView();

        System.setIn(input("a"));

        //when //then
        assertThatThrownBy(()-> inputView.inputTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 숫자 여야 합니다.");

    }

    @DisplayName("횟수가 0이하인 경우 예외가 발생한다.")
    @Test
    void OutOfRangeException(){
        //given
        InputView inputView = new InputView();

        System.setIn(input("-1"));

        //when //then
        assertThatThrownBy(() -> inputView.inputTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 1 이상 이어야 합니다.");
    }

    InputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}