package racingcar;

import racingcar.controller.ComputerNumberChecker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerNumberCheckerTest {

    @Test
    public void isComputerNumberGreaterThanFour_ShouldReturnTrue_WhenNumberIsGreaterThanOrEqualToFour() {
        ComputerNumberChecker checker = new ComputerNumberChecker();
        boolean result = checker.isComputerNumberGreaterThanFour(5);
        assertThat(result).isTrue();
    }

    @Test
    public void isComputerNumberGreaterThanFour_ShouldReturnFalse_WhenNumberIsLessThanFour() {
        ComputerNumberChecker checker = new ComputerNumberChecker();
        boolean result = checker.isComputerNumberGreaterThanFour(3);
        assertThat(result).isFalse();
    }

    @Test
    public void isComputerNumberGreaterThanFour_ShouldThrowIllegalArgumentException_WhenNumberIsNegative() {
        ComputerNumberChecker checker = new ComputerNumberChecker();
        assertThatThrownBy(() -> checker.isComputerNumberGreaterThanFour(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
