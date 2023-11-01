package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

public class CarsTest {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVED_POSITION = 1;
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;
    List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("pobi", "crong", "honux");
    }

    @Test
    void createCars() {
        Cars cars = Cars.of(names);
        assertThat(cars.get()).isEqualTo(List.of(
                Car.of("pobi", INITIAL_POSITION),
                Car.of("crong", INITIAL_POSITION),
                Car.of("honux", INITIAL_POSITION)
        ));
    }

    @Test
    void race() {
        Cars cars = Cars.of(names);
        NumberGenerator numberGenerator = () -> MOVABLE_NUMBER;

        List<Car> racedCars = cars.race(numberGenerator);
        assertThat(racedCars).isEqualTo(
                List.of(
                        Car.of("pobi", MOVED_POSITION),
                        Car.of("crong", MOVED_POSITION),
                        Car.of("honux", MOVED_POSITION)
                )
        );
    }

    @Test
    void getWinnerNames() {
        Cars cars = Cars.of(names);
        List<Car> carList = cars.get();

        carList.get(0).move(MOVABLE_NUMBER);
        carList.get(1).move(MOVABLE_NUMBER);
        carList.get(2).move(NON_MOVABLE_NUMBER);

        List<String> winnerNames = cars.getWinnerNames();
        List<String> expected = List.of("pobi", "crong");

        assertThat(winnerNames).isEqualTo(expected);
    }

}
