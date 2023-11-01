package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Iterator;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarNameHandler;
import racingcar.controller.ErrorMessage;

public class CarNameHandlerTest {
    private CarNameHandler carNameHandler;

    @BeforeEach
    public void setup() {
        carNameHandler = new CarNameHandler();
    }

    @Test
    public void testHandleValidInput() {
        carNameHandler.handle("Car1,Car2,Car3");
        Iterator<String> resultCarNames = carNameHandler.getHandledResult();

        ArrayList<String> exactCarNames = new ArrayList<>();

        while (resultCarNames.hasNext()) {
            exactCarNames.add(resultCarNames.next());
        }

        assertThat(exactCarNames).containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    public void testHandleEmptyName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carNameHandler.handle("Car1,,Car3"))
                .withMessage(ErrorMessage.EMPTY_NAME_EXCEPTION_MESSAGE);
    }

    @Test
    public void testHandleNameLengthExceedsMax() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carNameHandler.handle("Car1,Car2222,Car3"))
                .withMessage(ErrorMessage.EXCEEDED_LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    public void testHandleNameDuplication() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carNameHandler.handle("Car1,Car1,Car3"))
                .withMessage(ErrorMessage.NAME_DUPLICATION_EXCEPTION_MESSAGE);
    }

    @Test
    public void testHandleInvalidCarCount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carNameHandler.handle("Car1"))
                .withMessage(ErrorMessage.MIN_CAR_COUNT_EXCEPTION_MESSAGE);
    }
}