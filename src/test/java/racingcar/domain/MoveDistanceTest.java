package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        assertThat(after).isEqualTo(before + 1);
    }

    @Test
    @DisplayName("결과 메시지를 요청하면 이동 거리에 맞는 문자열을 반환하는가")
    void toResultMessage() {
        // given
        final MoveDistance before = new MoveDistance();
        final MoveDistance after = before.next();
        final int expectedDistance = after.toValue();
        final String expected =
                IntStream.range(0, expectedDistance)
                        .mapToObj(i -> "-")
                        .collect(Collectors.joining());

        // when
        final String resultMessage = after.toResultMessage();

        // then
        assertThat(resultMessage).contains(expected);
    }
}
