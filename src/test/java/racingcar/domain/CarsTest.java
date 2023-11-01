package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.domain.strategy.TestMoveStrategy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {
    private static final int MOVE = 1;
    private static final int STOP = 0;
    private static final TestMoveStrategy testMoveStrategy = new TestMoveStrategy(0);
    private static Cars testCars;

    @BeforeAll
    static void setUp() {
        String[] names = IntStream.range(0, 10)
                .mapToObj(i -> "car" + i)
                .toArray(String[]::new);
        testCars = new Cars(List.of(names), testMoveStrategy);
    }

    @Test
    void _4_미만_멈춤_4_이상_직진() {
        assertRandomNumberInRangeTest(
                () -> {
                    String[] names = IntStream.range(0, 10)
                            .mapToObj(i -> "car" + i)
                            .toArray(String[]::new);
                    Cars cars = new Cars(List.of(names),
                            new RandomMoveStrategy());

                    cars.moveAllCars();

                    List<Car> allCars = cars.getAllCars();
                    List<Integer> positions = allCars.stream().map(Car::getPosition).collect(toList());
                    List<Integer> target = new ArrayList<>(
                            List.of(STOP, STOP, STOP, STOP, MOVE,
                                    MOVE, MOVE, MOVE, MOVE, MOVE));
                    assertThat(positions).isEqualTo(target);
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @Test
    void _4_이상_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    String[] names = IntStream.range(0, 10)
                            .mapToObj(i -> "car" + i)
                            .toArray(String[]::new);
                    Cars cars = new Cars(List.of(names),
                            new RandomMoveStrategy());

                    cars.moveAllCars();
                    List<Car> winners = cars.findWinners();

                    List<String> winnerNames = winners.stream()
                            .map(Car::getName)
                            .collect(toList());
                    assertThat(winnerNames).containsExactly("car4", "car5", "car6", "car7", "car8", "car9");
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,2", "6,3", "7,4", "8,5", "9,6"})
    void 정지_전진(int pickedNumber, int expectedPosition) {
        testMoveStrategy.setNumber(pickedNumber);
        testCars.moveAllCars();
        List<Car> allCars = testCars.getAllCars();
        for (Car car : allCars) {
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }
}
