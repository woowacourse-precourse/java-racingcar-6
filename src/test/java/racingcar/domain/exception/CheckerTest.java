package racingcar.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CheckerTest {

    @DisplayName("쉼표 전후에 값이 올바른 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"hi,my,name,is,hello,world:6"}, delimiterString = ":")
    void hasCommasWithoutSurroundingValues(String valid, int expectedSize) {
        // 유효한 이름 테스트
        String[] validValues = Checker.hasCommasWithoutSurroundingValues(valid);
        assertThat(validValues).isNotEmpty().hasSize(expectedSize);
    }

    @DisplayName("쉼표 전후에 값이 없는 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123,,", ",123,", ",,123"})
    void hasCommasWithoutSurroundingValues(String val) {
        // 유효하지 않은 이름 테스트
        assertThatThrownBy(() -> Checker.hasCommasWithoutSurroundingValues(val))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표(,) 전후에 아무런 값이 없는 경우가 있습니다.");
    }

    @DisplayName("입력한 이름이 5자 이하인지 확인하는 테스트")
    @Test
    void lenCheck() {
        String[] validNames = {"hi", "my", "name", "is", "hello", "world"};
        String[] invalidNames = {"hi", "my", "name", "is", "hello", "world123"};

        // 유효한 이름 배열 테스트
        assertThatCode(() -> Checker.lenCheck(validNames)).doesNotThrowAnyException();

        // 유효하지 않은 이름 배열 테스트
        assertThatThrownBy(() -> Checker.lenCheck(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("숫자를 입력 했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "100"})
    void typeCheck1(String value) {
        // 유효한 이름 배열 테스트
        int result = Checker.typeCheck(value);
        assertThat(result).isInstanceOf(Integer.class);
    }

    @DisplayName("문자를 입력 했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"test", "1회", "ㅁㄴㅇㄴㅁㅁㅇ"})
    void typeCheck2(String value) {
        // 유효한 이름 배열 테스트
        assertThatThrownBy(() -> Checker.typeCheck(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }
}