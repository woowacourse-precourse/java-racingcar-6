package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputViewTest {
    InputView consoleInputView = new ConsoleInputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("쉼표를 기준으로 이름 목록이 제대로 반환되는지 확인")
    public void splitCarNamesWithDelimiterTest() {
        String line = "1번차량,2번차량,3번차량";
        System.setIn(new ByteArrayInputStream(line.getBytes()));

        List<String> strings = consoleInputView.enterCarNames();
        assertThat(strings).isEqualTo(List.of("1번차량", "2번차량", "3번차량"));
    }

    @Test
    @DisplayName("레이싱 횟수로 숫자가 아닌 값이 입력된 경우")
    public void enterRaceCountIsNotIntegerFailTest() {
        String line = "숫자가 아님";
        System.setIn(new ByteArrayInputStream(line.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> consoleInputView.enterRaceCount());
    }
}