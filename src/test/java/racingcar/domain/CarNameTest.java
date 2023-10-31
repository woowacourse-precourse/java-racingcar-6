package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("CarName 테스트")
class CarNameTest {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    @DisplayName("유효한 이름 길이로 CarName 생성")
    @Test
    void createCarNameWithValidLength() {
        assertDoesNotThrow(() -> new CarName("ABC"));
    }

    @DisplayName("CarName 생성 시 Null 이름")
    @Test
    void createCarNameWithNull() {
        Throwable result = catchThrowable(() -> new CarName(null));
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("CarName 생성 시 빈 문자열 이름")
    @Test
    void createCarNameWithEmptyString() {
        Throwable result = catchThrowable(() -> new CarName(""));
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("CarName 생성 시 공백 문자열 이름")
    @Test
    void createCarNameWithBlankString() {
        Throwable result = catchThrowable(() -> new CarName(" "));
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("CarName 이름 길이 초과 시 예외 발생")
    @Test
    void createCarNameWithExcessiveLength() {
        Throwable result = catchThrowable(() -> new CarName("A".repeat(NAME_LENGTH_MAX + 1)));
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
