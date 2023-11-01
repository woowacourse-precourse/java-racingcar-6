package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiscriminatorTest {

    @Test
    void validateCarNumber_최소값_미만() {
        assertThatThrownBy(() -> Discriminator.validateCarNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The # cars should be in range (1,8)");
    }

    @Test
    void validateCarNumber_최대값_초과() {
        assertThatThrownBy(() -> Discriminator.validateCarNumber(9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The # cars should be in range (1,8)");
    }

    @Test
    void validateCarName_길이_초과() {
        assertThatThrownBy(() -> Discriminator.validateCarName("longcarname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid car name.");
    }

    @Test
    void validateCarName_공백_포함() {
        assertThatThrownBy(() -> Discriminator.validateCarName("car with space"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid car name.");
    }

    @Test
    void validateCarName_작은따옴표_포함() {
        assertThatThrownBy(() -> Discriminator.validateCarName("car'"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid car name.");
    }

    @Test
    void validateCarName_큰따옴표_포함() {
        assertThatThrownBy(() -> Discriminator.validateCarName("car\""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid car name.");
    }

    @Test
    void validateTrialCount_음수() {
        assertThatThrownBy(() -> Discriminator.validateTrialCount("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The # trials should be a positive integer");
    }

    @Test
    void validateTrialCount_숫자로_변환_불가() {
        assertThatThrownBy(() -> Discriminator.validateTrialCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid trial count. Please enter a valid Integer");
    }
}

