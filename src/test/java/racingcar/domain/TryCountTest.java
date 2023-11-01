package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("시도 횟수 도메인 객체에")
class TryCountTest {

    @Test
    @DisplayName("생성 요청시 1보다 작은 숫자면 예외를 던지는가")
    void createValidation() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new TryCount(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("남은 시도 횟수가 있는지 확인 요청시")
    class HasLeftCount {

        @Test
        @DisplayName("횟수가 남아있으면 true를 반환하는가")
        void moreThanOneLeft() {
            // given
            final TryCount tryCount = new TryCount(1);

            // when
            final boolean result = tryCount.hasLeftCount();

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("남은 횟수가 없다면 false를 반환하는가")
        void noneLeft() {
            // given
            final TryCount tryCount = new TryCount(1);
            tryCount.next();

            // when
            final boolean result = tryCount.hasLeftCount();

            // then
            assertThat(result).isTrue();
        }
    }

    @Nested
    @DisplayName("다음 시도 횟수 요청시")
    class Next {

        @Test
        @DisplayName("현재 시도 횟수가 1 이상인 경우 1이 줄어든 시도 횟수를 반환하는가")
        void atLeastOne() {
            // given
            final TryCount tryCount = new TryCount(1);
            final boolean before = tryCount.hasLeftCount();

            // when
            final boolean after = tryCount.next().hasLeftCount();

            // then
            assertThat(after).isNotEqualTo(before);
        }

        @Test
        @DisplayName("현재 시도 횟수가 0 이하인 경우 예외를 던지는가")
        void zero() {
            // given
            final TryCount tryCount = new TryCount(1);
            final TryCount exceptionExpected = tryCount.next();

            // when
            // then
            assertThatThrownBy(exceptionExpected::next).isInstanceOf(IllegalStateException.class);
        }
    }
}
