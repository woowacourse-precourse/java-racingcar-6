package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.view.InputConsoleView;

public class InputConsoleViewTest {

    private final InputConsoleView inputConsoleView = new InputConsoleView();

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


    void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
