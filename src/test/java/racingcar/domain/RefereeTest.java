package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee;

    @BeforeEach
    void init() {
        referee = new Referee();
    }

    @Test
    @DisplayName("자동차 이름 입력 성공")
    void successInputCarNames() {
        // Given
        String inputCarNames = "pobi,woni,jun";

        // When
        List<String> carNames = referee.inputCarNames(inputCarNames);

        // Then
        assertThat(carNames).contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("중복 입력 시 예외 발생")
    void failedInputDuplicate() {
        // Given
        String inputCarNames = "pobi,pobi,jun";

        // When
        // Then
        assertThatThrownBy(() -> referee.inputCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("앞, 중간, 뒤에 공백이 존재할 경우 예외 발생")
    void failedInputBetweenBlank() {
        // Given
        String inputCarNamesFirstBlank = ",woni,jun";
        String inputCarNamesBetweenBlank = "pobi,,jun";
        String inputCarNamesEndBlank = "pobi,woni,";

        // When
        // Then
        assertThatThrownBy(() -> referee.inputCarNames(inputCarNamesFirstBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 앞, 중간, 뒤에 공백없이 자동차를 입력하세요.");

        assertThatThrownBy(() -> referee.inputCarNames(inputCarNamesBetweenBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 앞, 중간, 뒤에 공백없이 자동차를 입력하세요.");

        assertThatThrownBy(() -> referee.inputCarNames(inputCarNamesEndBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 앞, 중간, 뒤에 공백없이 자동차를 입력하세요.");
    }

    @Test
    @DisplayName("5글자 이상 입력 시 예외 발생")
    void failedInputOverMaxLength() {
        // Given
        String inputCarNames = "pobi,woooonie,jun";

        // When
        // Then
        assertThatThrownBy(() -> referee.inputCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름을 5자 이하로 입력하세요.");
    }

    @Test
    @DisplayName("\"\" 입력 시 예외 발생")
    void failedInputNone() {
        // Given
        String inputCarNames = "";

        // When
        // Then
        assertThatThrownBy(() -> referee.inputCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 두 개 이상의 자동차를 입력하세요.");
    }
}