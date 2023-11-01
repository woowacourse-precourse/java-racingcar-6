package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.constant.MoveStatus;

@DisplayName("숫자 도메인의 객체에")
class NumberTest {

    @Nested
    @DisplayName("생성 요청시")
    class CreateValidation {

        @Test
        @DisplayName("0보다 작은 수인 경우 예외를 던지는가")
        void lessThan0() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Number(-1)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("9보다 큰 수인 경우 예외를 던지는가")
        void greaterThan9() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Number(10)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("이동 여부 확인 요청시")
    class IsMovable {

        @Test
        @DisplayName("4보다 작은 경우 STOP을 반환하는가")
        void lessThan4() {
            // given
            final Number number = new Number(3);

            // when
            final MoveStatus moveStatus = number.checkMoveStatus();

            // then
            assertThat(moveStatus).isEqualTo(MoveStatus.STOP);
        }

        @Test
        @DisplayName("4 이상인 경우 MOVE를 반환하는가")
        void equalOrGreaterThan4() {
            // given
            final Number number = new Number(4);

            // when
            final MoveStatus moveStatus = number.checkMoveStatus();

            // then
            assertThat(moveStatus).isEqualTo(MoveStatus.MOVE);
        }
    }
}
