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
}