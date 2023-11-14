package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AttemptCountTest {
    @Test
    void new_시도할_횟수가_0회_이하인_경우_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new AttemptCount(0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 0회 초과만 가능합니다.");
    }

    @Test
    void from_올바른_숫자_형식이_아닌_경우_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> AttemptCount.from("1.0"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자 형식이 아닙니다.");
    }

    @Test
    void attemptIfPossible_시도할_횟수가_남은_경우_1회_차감_후_true_반환() {
        AttemptCount attemptCount = new AttemptCount(1);

        assertThat(attemptCount.attemptIfPossible()).isTrue();
    }

    @Test
    void attemptIfPossible_시도할_횟수가_남지_않은_경우_false_반환() {
        AttemptCount attemptCount = new AttemptCount(1);

        attemptCount.attemptIfPossible();

        assertThat(attemptCount.attemptIfPossible()).isFalse();
    }
}
