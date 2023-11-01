package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차의 전진 횟수만큼 문자(-)로 변환하여 반환한다.")
    void getMoveCountToString() {
        // given
        Car car = new Car("test", 2);

        // when
        String actual = car.getMoveCountToString();

        // then
        String expected = "--";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 전진 횟수가 최대일 경우 우승자이다.")
    void isWinner() {
        // given
        int maxMoveCount = 2;
        Car car = new Car("test1", maxMoveCount);

        // when, then
        assertThat(car.isWinner(maxMoveCount)).isTrue();
    }

    @Test
    @DisplayName("자동차의 전진 횟수가 최대값 보다 작을 경우 우승자가 아니다.")
    void isNotWinner() {
        // given
        int maxMoveCount = 2;
        int moveCount = 1;
        Car car = new Car("test1", moveCount);

        // when, then
        assertThat(car.isWinner(maxMoveCount)).isFalse();
    }
}