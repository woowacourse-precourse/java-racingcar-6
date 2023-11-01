package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 도메인 객체에")
class RacingCarTest {

    @Test
    @DisplayName("이동을 요청하면 움직인 거리가 1 늘어나는가")
    void move() {
        // given
        final RacingCar racingCar = new RacingCar("hello");
        final int before = racingCar.moveDistance();

        // when
        racingCar.move();

        // then
        assertThat(racingCar.moveDistance()).isEqualTo(before + 1);
    }

    @Test
    @DisplayName("결과 메시지를 요청하면 이름과 움직인 거리에 맞는 문자열을 반환하는가")
    void toResultMessage() {
        // given
        final String hello = "hello";
        final RacingCar racingCar = new RacingCar(hello);
        racingCar.move();

        // when
        final String result = racingCar.toResultMessage();

        // then
        assertThat(result).contains(hello, " : ", "-").doesNotContain("--");
    }

    @Nested
    @DisplayName("이동한 거리와 일치하는지 비교를 요청할 때")
    class HasSameDistance {

        @Test
        @DisplayName("일치하는 경우 true를 반환하는가")
        void sameDistance() {
            // given
            final RacingCar racingCar = new RacingCar("hello");
            final int distance = racingCar.moveDistance();

            // when
            final boolean result = racingCar.hasSameDistance(distance);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("일치하지 않는 경우 false를 반환하는가")
        void differentDistance() {
            // given
            final RacingCar racingCar = new RacingCar("hello");
            final int distance = racingCar.moveDistance();

            // when
            final boolean result = racingCar.hasSameDistance(distance + 1);

            // then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("동일한지 비교를 요청할 때")
    class Equals {

        @Test
        @DisplayName("이름이 같고 움직인 거리가 같다면 true를 반환하는가")
        void sameNameAndDistance() {
            // given
            final RacingCar first = new RacingCar("hello");
            final RacingCar second = new RacingCar("hello");
            first.move();
            second.move();

            // when
            final boolean result = first.equals(second);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("이름이 같고 움직인 거리가 달라도 true를 반환하는가")
        void sameNameAndDifferentDistance() {
            // given
            final RacingCar first = new RacingCar("hello");
            final RacingCar second = new RacingCar("hello");
            first.move();

            // when
            final boolean result = first.equals(second);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("이름이 다르면 false를 반환하는가")
        void differentName() {
            // given
            final RacingCar first = new RacingCar("hello");
            final RacingCar second = new RacingCar("bye");

            // when
            final boolean result = first.equals(second);

            // then
            assertThat(result).isFalse();
        }
    }
}
