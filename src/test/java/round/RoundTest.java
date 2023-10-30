package round;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.RoundValidator;

public class RoundTest {

    @Test
    void 경기_횟수는_1이상_이어야한다() {

        String acceptedRound = "1";
        String unAcceptedRound1 = "0";
        String unAcceptedRound2 = "-1";
        String unAcceptedRound3 = "가나다";

        assertDoesNotThrow(() ->
            RoundValidator.validateRounds(acceptedRound)
        );

        assertThrows(IllegalArgumentException.class,
            () -> RoundValidator.validateRounds(unAcceptedRound1)
        );

        assertThrows(IllegalArgumentException.class,
            () -> RoundValidator.validateRounds(unAcceptedRound2)
        );

        assertThrows(IllegalArgumentException.class,
            () -> RoundValidator.validateRounds(unAcceptedRound3)
        );
    }

    @Test
    void 경기_횟수는_숫자로만_이뤄져야한다() {
        String unAcceptedRound = "Error";

        assertThrows(IllegalArgumentException.class,
            () -> RoundValidator.validateRounds(unAcceptedRound)
        );
    }
}