package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingAttemptInput;

public class RacingAttemptInputTest {

    private RacingAttemptInput racingAttemptInput;

    @BeforeEach
    void SetUp() {
        racingAttemptInput = new RacingAttemptInput();
    }

    @Test
    void 정상적_문자열_숫자를_입력했을_때_해당_정수로_변환되어야_한다() {
        String input = "5";
        int result = racingAttemptInput.convertToInteger(input);

        assertEquals(5, result);
    }
}
