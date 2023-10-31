package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CountTest {

    @DisplayName("down() 테스트 : 카운트 숫자를 하나 감소시킨다.")
    @Test
    void down() {
        Count count = new Count(4);

        Count result = count.down();

        assertThat(result).isEqualTo(new Count(3));
    }

    @DisplayName("isCountZero() 테스트 : 카운트가 0이라면 true를 반환한다.")
    @Test
    void isCountZero_0이면_true() {
        Count count = new Count(0);

        boolean result = count.isCountZero();

        assertThat(result).isTrue();
    }

    @DisplayName("isCountZero() 테스트 : 카운트가 0이 아니라면 false를 반환한다.")
    @Test
    void isCountZero_0이_아니라면_false() {
        Count count = new Count(1);

        boolean result = count.isCountZero();

        assertThat(result).isFalse();
    }

    @DisplayName("down() 예외 테스트 : 0일 때 감소시키려고 하면 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_카운트가_0일때_감소시키려는_경우() {
        Count count = new Count(0);

        assertThatThrownBy(() -> count.down())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 남은 카운트가 없습니다.");
    }

}