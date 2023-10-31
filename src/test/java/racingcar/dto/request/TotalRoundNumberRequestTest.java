package racingcar.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TotalRoundNumberRequestTest {

    @Test
    @DisplayName("라운드 수가 0이하면 예외 발생")
    public void TotalRoundNumberRequest_생성자에서_라운드수가_0이하인_경우_예외가_발생한다() {
        assertThrows(
                UserInputException.class, () -> new TotalRoundNumberRequest(0)
        );
    }
}