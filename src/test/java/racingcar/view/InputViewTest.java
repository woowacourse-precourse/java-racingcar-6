package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView = new InputView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 쉽표를_기준으로_구분하여_입력받는다() {
        // given
        String inputString = "pobi,woni,jun\n";
        // when
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        List<String> carNames = inputView.inputCarNameStrings();
        // then
        Assertions.assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 숫자를_입력받는다() {
        // given
        String inputString = "5\n";
        // when
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        int roundCount = inputView.inputRoundCount();
        // then
        Assertions.assertThat(roundCount).isEqualTo(5);
    }

    @Test
    void 숫자가_아닌_문자를_입력받으면_예외를_발생시킨다() {
        // given
        String inputString = "a\n";
        // when
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // then
        Assertions.assertThatThrownBy(() -> inputView.inputRoundCount())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자를 입력해주세요.");
    }
}