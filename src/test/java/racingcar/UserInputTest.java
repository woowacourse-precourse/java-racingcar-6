package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    @Test
    void 자동차_이름을_입력받아_리스트로_반환() {
        String inputCarNames = "pobi,woni,jun";

        UserInput userInput = new UserInput();
        List<String> carNames = userInput.getCarNames(inputCarNames);

        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("pobi");
        assertThat(carNames.get(1)).isEqualTo("woni");
        assertThat(carNames.get(2)).isEqualTo("jun");
    }

    @Test
    void 시도할_횟수를_입력받아_정수로_반환() {
        String inputNumber = "5";
        UserInput userInput = new UserInput();

        int attemptsNumber = userInput.getAttemptsNumber(inputNumber);

        assertThat(attemptsNumber).isEqualTo(5);
    }

    @Test
    void 시도할_횟수가_숫자가_아니면_예외발생() {
        String inputNumber = "pobi";
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> userInput.getAttemptsNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자만 가능합니다.");
    }
}