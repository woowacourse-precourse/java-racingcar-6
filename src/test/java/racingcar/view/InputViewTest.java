package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "Car1,Car2,Car3";
        setInput(input);
        InputView inputView = new InputView();

        // when
        List<String> names = inputView.readCarNames();

        // then
        assertThat(names).isEqualTo(List.of("Car1", "Car2", "Car3"));
    }

    @Test
    void 자동차_공백_포함한_이름_입력_테스트() {
        // given
        String input = "Car1, Car2, Car3";
        setInput(input);
        InputView inputView = new InputView();

        // when
        List<String> names = inputView.readCarNames();

        // then
        assertThat(names).isEqualTo(List.of("Car1", "Car2", "Car3"));
    }

    @Test
    void 자동차_이름_입력_빈값_예외_테스트() {
        // given
        String input = " ";
        setInput(input);
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(inputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_INPUT_SIZE_ERROR.getMessage());
    }

    @Test
    void 시도_횟수_입력_테스트() {
        // given
        String input = "5";
        setInput(input);
        InputView inputView = new InputView();

        // when
        int tryCount = inputView.readTryCount();

        // then
        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        // given
        String input = "-3";
        setInput(input);
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(inputView::readTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_잘못된_입력_예외_테스트() {
        // given
        String input = "invalidInput";
        setInput(input);
        InputView inputView = new InputView();

        // given & then
        assertThatThrownBy(inputView::readTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
    }

    private void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }


}