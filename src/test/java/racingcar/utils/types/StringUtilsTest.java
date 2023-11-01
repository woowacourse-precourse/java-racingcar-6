package racingcar.utils.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("[String Utils]")
class StringUtilsTest {

    @Test
    @DisplayName("입력 한 문자가 범위 내에 있으면 성공")
    public void isSuccessStringInRange() {
        Assertions.assertTrue(StringUtils.isLengthInRange("abcdb", 1, 5));
    }

    @Test
    @DisplayName("입력 한 문자가 범위 내에 없으면 실패")
    public void isFalureStringInRange() {
        Assertions.assertFalse(StringUtils.isLengthInRange("abcdb", 1, 4));
    }

    @Test
    @DisplayName("입력 한 문자가 Null이면 예외")
    public void isExceptionStringIsnull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringUtils.isLengthInRange(null, 1, 4));
    }


    @Test
    @DisplayName("숫자 범위를 음수로 적으면 예외")
    public void isExceptionInvalidRange() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> StringUtils.isLengthInRange("abcdb", 1, -4));
    }
}