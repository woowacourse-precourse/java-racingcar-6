package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @AfterEach
    void clean() {
        Console.close();
    }

    @Test
    void inputCarNames() {
        // given
        inputView = new InputView();
        String input = "Tom,Bob,Lisa";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String[] result = inputView.inputCarNames();

        // then
        assertThat(result).containsExactly("Tom", "Bob", "Lisa");
    }

    @Test
    void inputTryNumber() {
        // given
        inputView = new InputView();
        String input = "5";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String result = inputView.inputTryNumber();

        // then
        assertThat(result).isEqualTo("5");
    }
}