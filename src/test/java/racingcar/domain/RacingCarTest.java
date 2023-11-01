package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Nested
    @DisplayName("레이싱카 이동 시도 시")
    class MoveRacingCar {
        private static Stream<Integer> successMoveScenarios() {
            return Stream.of(
                    RacingCar.MOVABLE_VALUE,
                    RacingCar.MOVABLE_VALUE + 1
            );
        }

        @ParameterizedTest
        @DisplayName("무작위 값이 정해진 기준 값 이상의 값인 경우 이동 성공")
        @MethodSource("successMoveScenarios")
        void success(int randomNumber) {
            RacingCar racingCar = new RacingCar("testCar");
            racingCar.move(randomNumber);
            assertThat(racingCar.getDistance()).isEqualTo(1);

        }

    }

    @Nested
    @DisplayName("레이싱카 이동 현황 요청 시")
    class PrintRacingCarDistance {

        @Test
        @DisplayName("이동 횟수 만큼 symbol 을 반복하여 그래프를 생성해 반환")
        void success() {
            RacingCar racingCar = new RacingCar("testCar");

            int countOfMove = 3;
            for (int i = 0; i < countOfMove; i++) {
                racingCar.move(RacingCar.MOVABLE_VALUE);
            }

            String visualizedDistance = RacingCar.SYMBOL.repeat(countOfMove);

            assertThat(racingCar.getDistanceGraph())
                    .isEqualTo(String.format("%s : %s", racingCar.getName(), visualizedDistance));
        }

    }

}