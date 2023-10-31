package racingcar.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;
class CarNameRequestTest {
    @Test
    @DisplayName("이름 길이가 6이상이면 예외 발생")
    public void CarNameRequest_생성자에서_이름_길이가_6이상인_경우_예외가_발생한다() throws Exception {
        assertThrows(
                UserInputException.class, () -> new CarNameRequest("java12")
        );
    }
}