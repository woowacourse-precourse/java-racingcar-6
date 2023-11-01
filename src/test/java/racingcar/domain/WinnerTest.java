package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinnerTest {

    @Test
    @DisplayName("최대 이동 횟수를 구하는 기능을 테스트한다.")
    void getMaxMovingCount_throwException() {
        /**
         * given : Car 객체가 담긴 List가 주어진다.
         * when : 모든 Car의 이동 횟수가 0일 때, Winner 객체를 생성한다면,
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        List<Car> carNames = List.of(
                new Car("rome", 0),
                new Car("seoul", 0),
                new Car("tokyo", 0));

        assertThatThrownBy(() -> new Winner(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("우승자가 없습니다. 게임을 종료합니다.");
    }

    @Test
    @DisplayName("최대 이동 횟수를 구하는 기능을 테스트한다.")
    void getMaxMovingCount_dontThrowException() {
        /**
         * given : Car 객체가 담긴 List가 주어진다.
         * when : 조건에 맞는 Winner 객체를 생성한다면,
         * then : 예외가 발생시키지 않는다.
         */
        List<Car> carNames = List.of(
                new Car("rome", 1),
                new Car("seoul", 2),
                new Car("tokyo", 1));

        assertThatCode(() -> new Winner(carNames))
                .doesNotThrowAnyException();
    }
}