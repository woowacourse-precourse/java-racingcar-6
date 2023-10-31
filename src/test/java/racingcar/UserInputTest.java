package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}