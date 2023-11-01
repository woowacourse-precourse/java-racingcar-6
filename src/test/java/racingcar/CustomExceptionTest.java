package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomExceptionTest {

    private CustomException customException = new CustomException();

    @Test
    @DisplayName("이름 길이 5 초과 예외 처리")
    public void checkInputValidLengthTest() {
        List<String> players = Arrays.asList("longName", "short");
        assertThrows(IllegalArgumentException.class, () -> customException.checkInputValidLength(players),
                "이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 이름이 있는 경우 예외 처리")
    public void checkInputDuplicationTest() {
        List<String> names = Arrays.asList("car1", "car3", "car1");

        assertThrows(IllegalArgumentException.class, () -> customException.checkInputDuplication(names),
                "중복된 이름이 있습니다.");
    }

    @Test
    public void testConvertStringToIntWithValidInput() {
        assertEquals(123, customException.convertStrToInt("123"));
    }

    @Test
    public void testConvertStringToIntWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () ->customException.convertStrToInt("abc"));
    }
}
