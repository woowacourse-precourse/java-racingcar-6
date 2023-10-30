package racingcar.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest extends NsTest {

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 실패한다.")
    void validateCarNamesTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "Test1", "Test2"));

        //when

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.validateCarNames(carNames);
        });
        assertEquals(ExceptionMessage.NOT_DUPLICATE_NAME, exception.getMessage());

    }

    @Test
    @DisplayName("자동차 이름에 빈 칸이 있을 경우 실패한다.")
    void validateEmptyTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "", "Test3"));

        //when

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.validateCarNames(carNames);
        });
        assertEquals(ExceptionMessage.NOT_EMPTY_AND_BLANK, exception.getMessage());
    }

    @Override
    protected void runMain() {
    }
}
