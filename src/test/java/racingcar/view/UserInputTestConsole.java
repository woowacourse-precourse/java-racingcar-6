package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserInputTestConsole extends NsConsoleIOTest {

    @Test
    void readCarNames_정상적인_입력_1() {
        // given
        String input = "pobi,wooni";
        setConsoleInput(input);

        // when
        UserInput userInput = new UserInput();
        List<String> carNames = userInput.readCarNames();

        // then
        assertThat(carNames).hasSize(2).contains("pobi", "wooni");
    }

    @Test
    void readCarNames_정상적인_입력_2() {
        // given
        String input = "ab,abc,eoir";
        setConsoleInput(input);

        // when
        UserInput userInput = new UserInput();
        List<String> carNames = userInput.readCarNames();

        // then
        assertThat(carNames).hasSize(3).contains("ab", "abc", "eoir");
    }


    @Test
    void readGameCount_정상적인_입력_1() {
        // given
        String input = "12";
        setConsoleInput(input);

        // when
        UserInput userInput = new UserInput();
        int gameCount = userInput.readGameCount();

        // then
        assertThat(gameCount).isEqualTo(12);
    }

    @Test
    void readGameCount_정상적인_입력_2() {
        // given
        String input = "10001";
        setConsoleInput(input);

        // when
        UserInput userInput = new UserInput();
        int gameCount = userInput.readGameCount();

        // then
        assertThat(gameCount).isEqualTo(10001);
    }

}