package racingcar.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCar 도메인 테스트")
class RacingCarTest {
    private final RacingCar testRacingCar = new RacingCar("test");

    @Nested
    @DisplayName("조회 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Getter {

        @Test
        @DisplayName("올바른 Name 값을 가져오는가")
        void Is_Getting_Expected_Name() {
            assertThat(testRacingCar.getName()).isEqualTo("test");
        }

        @DisplayName("올바른 Distance 값을 가져오는가")
        @ParameterizedTest(name = "{index} : 이동여부 = {0}, 기댓값 = {1}")
        @MethodSource("argumentsForGettingDistanceTest")
        void Is_Getting_Expected_Distance(boolean isMove, long expectedMovementResult) {
            // when
            if (isMove) {
                testRacingCar.move();
            }

            // then
            assertThat(testRacingCar.getDistance()).isEqualTo(expectedMovementResult);
        }
        private static Stream<Arguments> argumentsForGettingDistanceTest() {
            return Stream.of(
                    Arguments.of(false, 0L),
                    Arguments.of(true, 1L),
                    Arguments.of(false, 1L),
                    Arguments.of(true, 2L)
            );
        }
    }

    @Nested
    @DisplayName("이동 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Movement {

        @DisplayName("정상적으로 이동하는가")
        @ParameterizedTest(name = "{index} : 이동여부 = {0}, 기댓값 = {1}")
        @MethodSource("argumentsForMovementTest")
        void Is_Expected_Movement(boolean isMove, long expectedMovementResult) {
            // when
            if (isMove) {
                testRacingCar.move();
            }

            // then
            assertThat(testRacingCar.getDistance()).isEqualTo(expectedMovementResult);
        }
        private static Stream<Arguments> argumentsForMovementTest() {
            return Stream.of(
                    Arguments.of(false, 0L),
                    Arguments.of(true, 1L),
                    Arguments.of(false, 1L),
                    Arguments.of(true, 2L)
            );
        }

    }




}