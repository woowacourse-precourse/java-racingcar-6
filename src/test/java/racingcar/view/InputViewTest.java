package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void 시도횟수_입력이_양의_정수일경우_정상적으로_진행() {
        Console.close();

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        inputView.getTrials();
    }

    @Test
    void 시도횟수_입력에_문자가_포함된경우_예외발생() {
        Console.close();

        String input = "5aa";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::getTrials).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 시도횟수_입력이_음수일경우_예외발생() {
        Console.close();

        String input = "-5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::getTrials).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_입력이_0일경우_예외발생() {
        Console.close();

        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::getTrials).isInstanceOf(IllegalArgumentException.class);
    }

}