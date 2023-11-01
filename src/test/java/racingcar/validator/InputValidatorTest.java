package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputValidatorTest {

    @Test
    void validateCarNameLength_ValidNames_NoException() {
        // Arrange
        List<Car> carNames = Arrays.asList(new Car("Car1"), new Car("Car2"), new Car("Car3"));

        // Act & Assert
        assertDoesNotThrow(() -> InputValidator.validateCarNameLength(carNames));
    }

    @Test
    void validateCarNameLength_InvalidName_ExceptionThrown() {
        // Arrange
        Car car1 = new Car("Car1");
        Car car2 = new Car("");
        List<Car> carNames = Arrays.asList(car1, car2);

        // Act & Assert
        assertThatThrownBy(() -> InputValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNameLength_InvalidNames_ExceptionThrown() {
        // Arrange
        List<Car> carNames = Arrays.asList(new Car("Car1"), new Car("Car22"), new Car("Car333"));

        // Act & Assert
        assertThatThrownBy(() -> InputValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void validateTrialNumber_ValidInput_NoException() {
        // Arrange
        String inputNum = "12345";

        // Act & Assert
        assertDoesNotThrow(() -> InputValidator.validateTrialNumber(inputNum));
    }

    @Test
    void validateTrialNumber_InvalidInput_ExceptionThrown() {
        // Arrange
        String inputNum = "1a2b3c";

        // Act & Assert
        assertThatThrownBy(() -> InputValidator.validateTrialNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자만 입력해야 합니다.");
    }

    @Test
    void validateTrialNumber_ZeroInput_ExceptionThrown() {
        // Arrange
        String inputNum = "0";

        // Act & Assert
        assertThatThrownBy(() -> InputValidator.validateTrialNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}