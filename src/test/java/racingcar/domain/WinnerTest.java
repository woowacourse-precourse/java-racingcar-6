package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @Test
    @DisplayName("최대 위치 값을 가진 자동차 이름을 반환한다")
    void getWinnersTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("b"),
                Car.zeroPositionFrom("c")));

        // when
        Winner winner = Winner.createFrom(cars);

        // then
        String actual = winner.toString();
        assertEquals("a, b, c", actual);
    }
}