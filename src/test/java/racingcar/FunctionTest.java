package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    private static final RacingCarGameConsole VALID_RACINGCARGAMECONSOLE
            = new RacingCarGameConsole("a", 1);

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void randomNumber에따른_전진_여부_판별(int randomNumber) {
        VALID_RACINGCARGAMECONSOLE.updateCarMovement(randomNumber);

        if (randomNumber < 4) {
            assertThat(0).isEqualTo(VALID_RACINGCARGAMECONSOLE.car.movedLately(0));
        }
        if (randomNumber >= 4) {
            assertThat(1).isEqualTo(VALID_RACINGCARGAMECONSOLE.car.movedLately(0));
        }
    }
}
