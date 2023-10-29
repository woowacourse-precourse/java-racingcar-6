package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.constant.MoveStatus;

import java.util.List;

@DisplayName("숫자 도메인 일급컬렉션의 객체에")
class NumbersTest {

    @Test
    @DisplayName("생성 요청시 요소가 2개보다 적은 경우 예외를 던지는가")
    void sizeSmallerThan2() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Numbers(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("이동 상태 요청시")
    class CreateValidation {

        @Test
        @DisplayName("인덱스의 숫자가 4보다 작은 경우 STOP을 반환하는가")
        void lessThan4() {
            // given
            final Numbers numbers = new Numbers(List.of(0, 9));

            // when
            final MoveStatus moveStatus = numbers.checkMoveStatus(0);

            // then
            assertThat(moveStatus).isEqualTo(MoveStatus.STOP);
        }

        @Test
        @DisplayName("인덱스의 숫자가 4와 같거나 보다 큰 경우 MOVE를 반환하는가")
        void equalOrGreaterThan4() {
            // given
            final Numbers numbers = new Numbers(List.of(0, 9));

            // when
            final MoveStatus moveStatus = numbers.checkMoveStatus(1);

            // then
            assertThat(moveStatus).isEqualTo(MoveStatus.MOVE);
        }
    }
}
