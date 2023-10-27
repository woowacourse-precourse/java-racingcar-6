package racingcount;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingCountValidator;

public class RacingCountTest {

    private RacingCountValidator racingCountValidator;

    @BeforeEach
    void setUp() {
        this.racingCountValidator = new RacingCountValidator();
    }

    @Test
    void 경기_횟수는_1이상_이어야한다() {

        String acceptedRacingCount = "1";
        String unAcceptedRacingCount1 = "0";
        String unAcceptedRacingCount2 = "-1";

        assertDoesNotThrow(() ->
            racingCountValidator.validateRacingCount(acceptedRacingCount)
        );

        assertThrows(IllegalArgumentException.class,
            () -> racingCountValidator.validateRacingCount(unAcceptedRacingCount1)
        );

        assertThrows(IllegalArgumentException.class,
            () -> racingCountValidator.validateRacingCount(unAcceptedRacingCount2)
        );
    }

    @Test
    void 경기_횟수는_숫자로만_이뤄져야한다() {
        String unAcceptedRacingCount = "Error";

        assertThrows(IllegalArgumentException.class,
            () -> racingCountValidator.validateRacingCount(unAcceptedRacingCount)
        );
    }
}