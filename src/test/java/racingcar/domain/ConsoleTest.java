package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConsoleTest {
    private final static String VALID_CAR_NAMES = "a,b,c";
    private final static Car VALID_CAR = new Car(VALID_CAR_NAMES);
    private static final GameConsole VALID_GAME_CONSOLE
            = new GameConsole(VALID_CAR, "1");

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void randomNumber에_따른_전진_여부_판별(int randomNumber) {
        VALID_GAME_CONSOLE.updateCarMovement(randomNumber);

        if (randomNumber < 4) {
            assertThat(0).isEqualTo(VALID_CAR.movedLately(0));
        }
        if (randomNumber >= 4) {
            assertThat(1).isEqualTo(VALID_CAR.movedLately(0));
        }
    }
}
