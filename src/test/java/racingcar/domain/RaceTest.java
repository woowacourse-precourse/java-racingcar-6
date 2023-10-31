package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Race 도메인 테스트")
class RaceTest {

    private final Race testRace = new Race(List.of("pobi", "woni", "jun"));
    private final int numberOfTestRacingCars = testRace.getRacingCars().size();


    @Nested
    @DisplayName("조회 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Getter {

        @Test
        @DisplayName("올바른 RacingCar 리스트를 가져오는가")
        void Case_Is_Expected_RacingCars() {
            // when
            List<RacingCar> expectedRacingCars = List.of(
                    new RacingCar("pobi"),
                    new RacingCar("woni"),
                    new RacingCar("jun")
            );

            // then
            assertThat(testRace.getRacingCars()).usingRecursiveComparison().isEqualTo(expectedRacingCars);
        }

        @ParameterizedTest(name = "{index} : 이동 여부 = [pobi | woni | jun] - {0} , 기댓값 : {1}")
        @DisplayName("올바른 Farthest Distance를 가져오는가")
        @MethodSource("argumentsForGettingFarthestDistanceTest")
        void Case_Is_Expected_Farthest_Distance(List<Boolean> givenMoveValues, Long expectedFarthestDistance) {
            // when
            List<RacingCar> racingCars = testRace.getRacingCars();

            // given
            for (int index = 0; index < numberOfTestRacingCars; index++) {
                RacingCar racingCar = racingCars.get(index);
                Boolean isCarMove = givenMoveValues.get(index);
                if (isCarMove) {
                    racingCar.move();
                }
            }

            // then
            assertThat(testRace.getMostFarthestDistance()).isEqualTo(expectedFarthestDistance);
        }
        private static Stream<Arguments> argumentsForGettingFarthestDistanceTest() {
            return Stream.of(
                    Arguments.of(List.of(true, true, false), 1L),
                    Arguments.of(List.of(false, true, false), 2L),
                    Arguments.of(List.of(true, false, false), 2L),
                    Arguments.of(List.of(true, false, false), 3L),
                    Arguments.of(List.of(true, false, false), 4L)
            );
        }

    }

    @Nested
    @DisplayName("서킷 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Circuit {

        private static final int MINIMUM_FARTHEST_DISTANCE = 0;

        @ParameterizedTest(name = "{index} : 해당 시나리오에서 발생할 수 있는 최대 거리 값 = {0}")
        @DisplayName("올바른 방식으로 서킷이 진행되는가")
        @ValueSource(longs = {
                1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L
        })
        void Case_Is_Expected_Circuit_Result(Long maxDistanceInScenario) {
            // when
            testRace.circuit();

            // then
            assertThat(testRace.getMostFarthestDistance())
                    .isLessThanOrEqualTo(maxDistanceInScenario); // 초과하는 최장거리가 존재할 수 없음

            assertThat(testRace.getMostFarthestDistance())
                    .isGreaterThanOrEqualTo(MINIMUM_FARTHEST_DISTANCE); // 초과하는 최장거리가 존재할 수 없음
        }
    }

}