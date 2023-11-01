package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.GameRuleValidator;

class GameRuleValidatorTest {
    @Test
    @DisplayName("유효한 이름의 경우 유효성 검사를 통과한다.")
    public void validateNameValid() {
        String validName = "Car";
        GameRuleValidator.validateName(validName);
    }

    @Test
    @DisplayName("잘못된 크기의 이름의 경우 예외를 던진다. : 5이상")
    public void validateNameInvalidSize() {
        String invalidName = "Abcddd";
        assertThatThrownBy(() -> GameRuleValidator.validateName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong Size Of Name");
    }

    @Test
    @DisplayName("잘못된 크기의 이름의 경우 예외를 던진다. : 0")
    public void validateNameInvalidSizeZero() {
        String invalidName = "";
        assertThatThrownBy(() -> GameRuleValidator.validateName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name is Empty");
    }

    @Test
    @DisplayName("중복된 이름이 있는 경우 예외를 던진다.")
    public void validateNamesDuplicate() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car1");
        assertThatThrownBy(() -> GameRuleValidator.validateNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Duplicated Name : Car1");
    }

    @Test
    @DisplayName("중복된 이름이 없는 경우 유효성 검사를 통과한다.")
    public void validateNamesNoDuplicate() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        GameRuleValidator.validateNames(carNames);
    }

}