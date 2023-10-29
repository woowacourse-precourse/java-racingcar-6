package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }

    @Test
    void 자동차이름_입력테스트() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String carNames = InputView.inputCarNames();
        assertThat(carNames).isEqualTo(input);
    }

    @Test
    void 자동차이름을_구분자_쉼표로_나누기() {
        String carNamesInput = "pobi,woni,jun";
        String[] splitNames = InputView.splitCarNames(carNamesInput);
        assertThat(splitNames).containsExactly("pobi", "woni", "jun");
    }
}
