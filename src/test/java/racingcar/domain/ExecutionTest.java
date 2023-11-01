package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExecutionTest {
    @DisplayName("시도 회수가 양의 정수인 경우 정상적으로 작동합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "100"})
    void 시도_회수_생성_테스트(String count) {
        Assertions.assertDoesNotThrow(() -> {
            new RacingCar(count);
        });
    }

    @DisplayName("시도 회수가 양의 정수가 아니면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "exception", "-1", "0.01"})
    void 시도_회수_생성_예외_테스트(String count) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Execution(count);
        });
    }
}
