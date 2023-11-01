package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RoundCountHandler;
import racingcar.controller.ErrorMessage;

public class RoundCountHandlerTest {
    private RoundCountHandler roundCountHandler;

    @BeforeEach
    public void setUp() {
        roundCountHandler = new RoundCountHandler();
    }

    @Test
    public void testHandleValidInput() {
        roundCountHandler.handle("5");
        assertThat(roundCountHandler.getHandledResult()).isEqualTo(5);
    }

    @Test
    public void testHandleZeroInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> roundCountHandler.handle("0"))
                .withMessage(ErrorMessage.NO_ROUND_EXCEPTION_MESSAGE);
    }

    @Test
    public void testHandleNonNumericInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> roundCountHandler.handle("absy"))
                .withMessage(ErrorMessage.NON_NUMERIC_EXCEPTION_MESSAGE);
    }
}