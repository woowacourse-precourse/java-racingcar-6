package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직인 거리 도메인의 객체에")
class MoveDistanceTest {

    @Test
    @DisplayName("이동을 요청하면 기존 값에 1이 더한 값을 갖는 인스턴스가 반환되는가")
    void next() {
        // given
        final MoveDistance moveDistance = new MoveDistance();
        final int before = moveDistance.toValue();

        // when
        final MoveDistance result = moveDistance.next();

        // then
        final int after = result.toValue();
        Assertions.assertThat(after).isEqualTo(before + 1);
    }

    @Test
    void toResultMessage() {
    }
}
