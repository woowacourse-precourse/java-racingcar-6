package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    void 실행횟수가_숫자가_아닐경우_에러() {
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readNumOfExecutions)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행횟수가_0이하일_경우_에러() {
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readNumOfExecutions)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
