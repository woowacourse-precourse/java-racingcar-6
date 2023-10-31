package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserInputTestConsole extends NsConsoleIOTest {
    @Test
    void readCarNames_정상적인_입력() {
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
    void readCarNames_쉼표로_시작하는_입력() {
        // given
        String input = ",pobi";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 입력이 (,) 쉼표로 시작되면 안됩니다.");
    }

    @Test
    void readCarNames_쉼표_중첩된_입력() {
        // given
        String input = "pobi,,woni";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 (,) 연속된 쉼표를 입력해서는 안됩니다.");
    }

    @Test
    void readCarNames_쉼표로_끝나는_입력() {
        // given
        String input = "pobi,";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 입력 끝에는 (,) 쉼표가 있으면 안됩니다.");
    }

    @Test
    void readCarNames_5글자가_넘는_입력() {
        // given
        String input = "pobi,woooni";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름의 길이는 5 이하여야 합니다.");
    }

    @Test
    void readCarNames_이름_중복() {
        // given
        String input = "pobi,pobi,abc";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름은 중복되면 안됩니다.");
    }

    @Test
    void readCarNames_이름_부분_중복_정상작동() {
        // given
        String input = "abcd,abc,ab";
        setConsoleInput(input);

        // when
        UserInput userInput = new UserInput();
        List<String> carNames = userInput.readCarNames();

        // then
        assertThat(carNames).hasSize(3).contains("abcd", "abc", "ab");
    }

    @Test
    void readCarNames_공백_비정상_입력() {
        // given
        String input = "pobi ,woni, a bc";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
    }


    @Test
    void readCarNames_공백인경우() {
        // given
        String input = " ";
        setConsoleInput(input);

        // when & then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
    }


    @Test
    void readGameCount_정상적인_입력() {
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
    void readGameCount_숫자가_아닌_입력() {
        // given
        String input = "a12b";
        setConsoleInput(input);

        // when and then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 숫자만 입력해야 합니다.");
    }

    @Test
    void readGameCount_0_입력() {
        // given
        String input = "0";
        setConsoleInput(input);

        // when and then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 양수만 입력해야 합니다.");
    }

    @Test
    void readGameCount_0_으로_시작하는_입력() {
        // given
        String input = "07";
        setConsoleInput(input);

        // when and then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수 입력은 0으로 시작하면 안됩니다.");
    }

    @Test
    void readGameCount_음수_입력() {
        // given
        String input = "-123";
        setConsoleInput(input);

        // when and then
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.readGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 양수만 입력해야 합니다.");
    }
}