package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveNumInputTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    @DisplayName ("자동차 이동횟수 입력 정상동작 테스트")
    void canGetMoveNameGeneralTest(String testInput) {
        MoveNum moveNum = new MoveNum(testInput);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (입력이 없을때)")
    void canHandleEmptyInputMoveNumExceptionTest(String testInput) {
    assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수에 값이 들어오지 않았습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "English", "-500", "50섞어서", "5a1"})
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (0 또는 양수가 아닌 값이 들어온 경우)")
    void canHandleNotInputMoveNumExceptionTest(String testInput) {
        assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수에 0 또는 양수가 아닌 값이 포함되었습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483649", "10001"})
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (이동횟수가 너무 많은 경우)")
    void canHandleOverLengthMoveNumExceptionTest(String testInput) {
        final int MAX_MOVE_NUM = 10000;
        assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
    }
}
