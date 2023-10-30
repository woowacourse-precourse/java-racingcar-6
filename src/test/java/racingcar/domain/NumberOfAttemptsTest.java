package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOfAttemptsTest {

    @DisplayName("시도 횟수 생성 시 최솟값보다 적을 경우 예외가 발생한다.")
    @Test
    void constructNumberOfAttempts_Fail_ByLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new NumberOfAttempts(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수 생성 시 최댓값보다 클 경우 예외가 발생한다.")
    @Test
    void constructNumberOfAttempts_Fail_ByGreaterThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new NumberOfAttempts(200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 남아 있으면 true를 반환한다.")
    @Test
    void hasRemainingAttempts_True() {
        // given
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(2);

        // when
        numberOfAttempts.decreaseNumberOfAttempts();

        // then
        Assertions.assertThat(numberOfAttempts.hasRemainingAttempts()).isTrue();
    }

    @DisplayName("시도 횟수가 남아 있지 않으면 false를 반환한다.")
    @Test
    void hasRemainingAttempts_False() {
        // given
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(1);

        // when
        numberOfAttempts.decreaseNumberOfAttempts();

        // then
        Assertions.assertThat(numberOfAttempts.hasRemainingAttempts()).isFalse();
    }
}
