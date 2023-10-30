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
    void validateCarNamesDuplicateTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "Test1", "Test2"));

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.validateCarNames(carNames);
        });

        //then
        assertEquals(ExceptionMessage.NOT_DUPLICATE_NAME, exception.getMessage());

    }

    @Test
    @DisplayName("자동차 이름에 빈 칸이 있을 경우 실패한다.")
    void validateCarNamesEmptyTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "", "Test3"));

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.validateCarNames(carNames);
        });

        //then
        assertEquals(ExceptionMessage.NOT_EMPTY_AND_BLANK, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과해서는 안된다.")
    void validateCarNamesGreaterThanFiveTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("TestTest1", "Test2", "Test3"));

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Validator.validateCarNames(carNames);
        });

        //then
        assertEquals(ExceptionMessage.NOT_MORE_THAN_FIVE, exception.getMessage());
    }

    @Override
    protected void runMain() {
    }
}
