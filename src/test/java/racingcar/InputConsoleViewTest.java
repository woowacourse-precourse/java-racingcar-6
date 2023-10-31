package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputConsoleView;

public class InputConsoleViewTest {

    private final InputConsoleView inputConsoleView = new InputConsoleView();

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력_성공() {
        //given
        String input = "userA,userB,userC";
        setIn(input);

        //when
        String result = inputConsoleView.readCarName();

        //then
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 자동차_이름_빈칸_입력() {
        //given
        String input = " ";
        setIn(input);

        //when,then
        assertThatThrownBy(inputConsoleView::readCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차들의 이름을 입력해주세요.");
    }

    @Test
    void 자동차_이름_쉼표_없이_입력() {
        //given
        String input = "userA userB userC";
        setIn(input);

        //when,then
        assertThatThrownBy(inputConsoleView::readCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차들의 이름은 ','으로 구분해주세요.");
    }

    @Test
    void 시도_횟수_입력_성공() {
        //given
        String input = "3";
        setIn(input);

        //when
        String result = inputConsoleView.readNumberOfTrial();

        //then
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 시도_횟수_빈칸_입력() {
        //given
        String input = " ";
        setIn(input);

        //when,then
        assertThatThrownBy(inputConsoleView::readNumberOfTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수를 입력해주세요.");
    }

    @Test
    void 시도_횟수_숫자가_아닌_입력() {
        //given
        String input = "two";
        setIn(input);

        //when,then
        assertThatThrownBy(inputConsoleView::readNumberOfTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }

    @Test
    void 시도_횟수_1보다_작은_값_입력() {
        //given
        String input = "0";
        setIn(input);

        //when,then
        assertThatThrownBy(inputConsoleView::readNumberOfTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1보다 커야됩니다.");
    }


    void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
