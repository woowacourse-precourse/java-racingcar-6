package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptCountTest {

    @ParameterizedTest(name = "[테스트 케이스 {index}] 입력한 시도 횟수 = {arguments} ")
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력한 시도 횟수가 1보다 작으면 예외가 발생한다.")
    public void should_ThrowException_When_AttemptCountUnderOne(int attemptCount) {
        assertThatThrownBy(() -> new AttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
