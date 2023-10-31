package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.validation.InputCountValidation;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TerminalViewTest {

    TerminalView terminalView = new TerminalView();

    @Test
    void inputNamesTest() {
        String input = "pobi,woni,jun";
        String[] names = input.split(",");

        List<String> list = Arrays.stream(names).toList();
        assertThat(list.size()).isEqualTo(3);

        for (String name : list) {
            assertThat(input).contains(name);
        }
    }

    @Test
    void inputCountTest() {
        String input = "1";
        assertThat(Integer.parseInt(InputCountValidation.inputCountValidation(input))).isEqualTo(1);
    }
}