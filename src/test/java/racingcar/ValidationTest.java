package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationTest {
    @Test
    void isNullTest() {
        final List<String> emptyList = new ArrayList<>();

        assertThatThrownBy(() -> Validation.isNull(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다. 게임을 종료합니다.");
    }

    @Test
    void isOverFiveTest() {
        // 변수이름이 너무 특징적이지 않다...?
        final List<String> overFiveList = Arrays.asList("car", "raceis", "fun");

        assertThatThrownBy(() -> Validation.isOverFive(overFiveList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 5자를 초과하였습니다. 게임을 종료합니다.");
    }

    @Test
    void isOverlapTest() {
        final List<String> overlappingList = Arrays.asList("start", "car", "race", "start");

        assertThatThrownBy(() -> Validation.isOverlapping(overlappingList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 입력값이 있습니다. 게임을 종료합니다.");
    }

    @Test
    void isNullStringTest() {
        final String emptyString = "";

        assertThatThrownBy(() -> Validation.isNullString(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다. 게임을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "wooteco"})
    void isNotIntegerTest(String notInteger) {
        assertThatThrownBy(() -> Validation.isNotInteger(notInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 정수여야 합니다. 게임을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void isBelowZeroTest(String belowZero) {
        assertThatThrownBy(() -> Validation.isBelowZero(belowZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1이상이어야 합니다. 게임을 종료합니다.");
    }
}