package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @DisplayName("자동차 이름에 공백이 존재 할 경우 실패")
    @Test
    void validateCarName_throwsException_whenNameContainsWhitespace() {
        String carName = " ";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Util.validateCarName(carName));
        assertEquals("자동차 이름에 공백이 포함되어 있습니다.", exception.getMessage());
    }

    @DisplayName("자동차 이름이 5자 이상인 경우 실패")
    @Test
    void validateCarName_throwsException_whenNameIsTooLong() {
        String carName = "123456";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Util.validateCarName(carName));
        assertEquals("자동차 이름은 5자 이하로 이루어져야 합니다!", exception.getMessage());
    }

    @DisplayName("자동차 이름에 중복이 있을 경우 실패")
    @Test
    void checkForDuplicates_throwsException_whenDuplicatesExist() {
        List<String> array = Arrays.asList("car1", "car1");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Util.checkForDuplicates(array));
        assertEquals("자동차 이름에 중복이 있어서는 안됩니다!", exception.getMessage());
    }

    @Test
    void checkForDuplicates_passes_whenNoDuplicatesExist() {
        List<String> array = Arrays.asList("car1", "car2");
        assertDoesNotThrow(() -> Util.checkForDuplicates(array));
    }
}
