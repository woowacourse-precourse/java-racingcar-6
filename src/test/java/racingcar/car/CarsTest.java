package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(
                new Car("a"),
                new Car("ab"),
                new Car("abc")
        ));
    }

    @DisplayName("입력된 차량들의 이름을 차량 리스트로 정확히 변환하는지 확인합니다.")
    @Test
    void fromNames_IsReturnCorrectCarList() {
        Cars actual = Cars.fromNames("a,ab,abc");
        Cars expected = cars;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("차량이 의도된대로 정확하게 전진하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProviderForRace")
    void race_IsMoveCorrectlyByInput(String testName, List<Integer> randomNumbers, List<Integer> locations) {
        int firstCarsExpectedLocation = locations.get(0);
        int secondCarsExpectedLocation = locations.get(1);
        int thirdCarsExpectedLocation = locations.get(2);

        Cars expected = new Cars(List.of(
                new Car("a", firstCarsExpectedLocation),
                new Car("ab", secondCarsExpectedLocation),
                new Car("abc", thirdCarsExpectedLocation)
        ));

        Cars actual = cars;
        actual.race(randomNumbers);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3개의 차량을 전진시킨 뒤, 우승자를 정확히 판별하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProviderForFindWinners")
    void findWinners_IsFindExactWinners(String testName, List<Integer> randomNumbers, List<Car> expectedWinners) {
        Cars actual = cars;

        actual.race(randomNumbers);
        assertThat(actual.findWinners()).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> argumentsProviderForRace() {
        return Stream.of(
                arguments("3개의 차량을 모두 전진시키지 않음", List.of(0, 1, 2), List.of(0, 0, 0)),
                arguments("3개의 차량을 모두 1번씩 전진", List.of(4, 5, 6), List.of(1, 1, 1)),
                arguments("3개의 차량을 각각 (0,0,1)칸 만큼 전진", List.of(0, 3, 7), List.of(0, 0, 1)),
                arguments("3개의 차량을 각각 (0,1,1)칸 만큼 전진", List.of(1, 8, 9), List.of(0, 1, 1)),
                arguments("3개의 차량을 각각 (0,1,0)칸 만큼 전진", List.of(0, 4, 1), List.of(0, 1, 0)),
                arguments("3개의 차량을 각각 (1,0,0)칸 만큼 전진", List.of(9, 2, 3), List.of(1, 0, 0)),
                arguments("3개의 차량을 각각 (1,1,0)칸 만큼 전진", List.of(4, 5, 3), List.of(1, 1, 0))
        );
    }

    static Stream<Arguments> argumentsProviderForFindWinners() {
        return Stream.of(
                arguments("첫 번째 차량만 우승자인 경우", List.of(4, 0, 0), List.of(new Car("a", 1))),
                arguments("두 번째 차량만 우승자인 경우", List.of(0, 9, 1), List.of(new Car("ab", 1))),
                arguments("세 번째 차량만 우승자인 경우", List.of(0, 2, 8), List.of(new Car("abc", 1))),
                arguments("1,2번째 차량의 공동 우승", List.of(4, 7, 0), List.of(
                        new Car("a", 1),
                        new Car("ab", 1))),
                arguments("1,3번째 차량의 공동 우승", List.of(5, 1, 6), List.of(
                        new Car("a", 1),
                        new Car("abc", 1))),
                arguments("2,3번째 차량의 공동 우승", List.of(1, 6, 9), List.of(
                        new Car("ab", 1),
                        new Car("abc", 1))),
                arguments("3개의 모든 차량이 공동 우승", List.of(7, 8, 9), List.of(
                        new Car("a", 1),
                        new Car("ab", 1),
                        new Car("abc", 1)))
        );
    }
}