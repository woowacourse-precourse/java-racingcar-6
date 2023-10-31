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
    void checkIfNullOrBlankList_emptyList_ExceptionThrown() {
        final List<String> emptyList = new ArrayList<>();

        assertThatThrownBy(() -> Validation.checkIfNullOrBlankList(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없거나 빈 공백만으로 이뤄져있습니다. 게임을 종료합니다.");
    }

    @Test
    void checkIfAnyBelowOneLength_elementLength0_ExceptionThrown() {
        final List<String> belowOneList = Arrays.asList("car", "", "fun");

        assertThatThrownBy(() -> Validation.checkIfAnyBelowOneLength(belowOneList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이여야 합니다. 게임을 종료합니다.");
    }

    @Test
    void checkIfAnyOverFiveLength_elementLength6_ExceptionThrown() {
        // 변수이름이 너무 특징적이지 않다...?
        final List<String> overFiveList = Arrays.asList("car", "raceis", "fun");

        assertThatThrownBy(() -> Validation.checkIfAnyOverFiveLength(overFiveList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과하였습니다. 게임을 종료합니다.");
    }

    @Test
    void checkIfAnyOverlapping_equalElement_ExceptionThrown() {
        final List<String> overlappingList = Arrays.asList("start", "car", "race", "start");

        assertThatThrownBy(() -> Validation.checkIfAnyOverlapping(overlappingList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 자동차 이름이 있습니다. 게임을 종료합니다.");
    }

    @Test
    void checkIfNullOrBlankString_emptyString_ExceptionThrown() {
        final String emptyString = "";

        assertThatThrownBy(() -> Validation.checkIfNullOrBlankString(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없거나 빈 공백으로 이뤄져있습니다. 게임을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "wooteco"})
    void checkIfNotInteger_inputString_ExceptionThrown(String notInteger) {
        assertThatThrownBy(() -> Validation.checkIfNotInteger(notInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다. 게임을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void checkIfNotPositiveNumber_inputNegative_ExceptionThrown(String belowZero) {
        assertThatThrownBy(() -> Validation.checkIfNotPositiveNumber(belowZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1이상이어야 합니다. 게임을 종료합니다.");
    }
}