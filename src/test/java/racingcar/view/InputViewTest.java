package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorCode;
import racingcar.util.Validator;

class InputViewTest {
    private final InputView inputView = new InputView(new Validator());

    @AfterEach
    private void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("경주차 이름을 입력받을 때, 길이가 5 이상인 경우 예외가 발생한다.")
    public void should_throwException_when_carNameInvalid() {
        //given
        System.setIn(getUserInput("pobi,crongcrong,hey"));

        //when&then
        assertThatThrownBy(inputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NAME_LENGTH.toString());
    }

    @ParameterizedTest
    @DisplayName("시도횟수를 입력받을 때, 숫자가 아닌 수가 들어오거나, int 범위에서 벗어난 경우 예외가 발생한다.")
    @ValueSource(strings = {"4r", "9999999999999999999"})
    public void should_throwException_when_invalidTryCount(String input) {
        //given
        System.setIn(getUserInput(input));

        //when&then
        assertThatThrownBy(inputView::getTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_INPUT.toString());
    }


    private InputStream getUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}