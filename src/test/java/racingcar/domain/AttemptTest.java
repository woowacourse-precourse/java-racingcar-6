package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptTest {

    @DisplayName("Attempt 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 50, 100})
    public void createAttempt(int attemptCount) throws Exception {
        //when
        Attempt attempt = new Attempt(attemptCount);

        //then
        assertThat(attempt.count()).isEqualTo(attemptCount);
    }

    @DisplayName("Attempt 생성 예외 : 시도회수가 0 이하이거나 100회를 초과하면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 101, 102})
    public void createAttempt_exception_isInRange(int outOfRangeNum) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Attempt(outOfRangeNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 1-100 사이로 입력해주세요");
    }
}
