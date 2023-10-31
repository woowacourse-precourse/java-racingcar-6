package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import racingcar.model.enums.MovingStatus;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class MovingStatusTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        numberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("Enum 인자를 확인한다.")
    @ParameterizedTest
    @EnumSource(value = MovingStatus.class)
    void testEnumSourceValue(MovingStatus movingStatus) {
    }

    @Test
    @DisplayName("4이상은 앞으로 전진한다.")
    void testForward() {
        int pickNumber = numberGenerator.pickNumber();
        boolean expectedCanMove = pickNumber >= 4;
        assertEquals(expectedCanMove, MovingStatus.canMove(pickNumber));
    }
}