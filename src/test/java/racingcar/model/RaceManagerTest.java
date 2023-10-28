package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceManagerTest {

    private static RaceManager raceManager;

    @BeforeAll
    public static void setup() {
        raceManager = new RaceManager();
    }

    @ParameterizedTest
    @DisplayName("입력값의 유효성 테스트")
    @ValueSource(strings = {"", "-1", "fjk"})
    public void validateNumberOfMoveTest(String playerInput) {
        //then
        assertThatThrownBy(() -> raceManager.validateNumberOfMove(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
