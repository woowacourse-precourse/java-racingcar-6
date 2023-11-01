package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDto;
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
        Cars cars = Cars.from(names);
        assertThat(cars.toDto())
                .hasSize(3)
                .containsExactly(
                        new CarDto("pobi", INITIAL_POSITION),
                        new CarDto("crong", INITIAL_POSITION),
                        new CarDto("honux", INITIAL_POSITION)
                );
    }

    @Test
    void race() {
        Cars cars = Cars.from(names);
        NumberGenerator numberGenerator = () -> MOVABLE_NUMBER;

        cars.race(numberGenerator);
        assertThat(cars.toDto())
                .containsExactly(
                        new CarDto("pobi", MOVED_POSITION),
                        new CarDto("crong", MOVED_POSITION),
                        new CarDto("honux", MOVED_POSITION)
                );
    }

    @Test
    void findWinnerNames() {

        Cars cars = Cars.from(names);
        NumberGenerator numberGenerator = new NumberGenerator() {
            private final int[] positions = {MOVABLE_NUMBER, MOVABLE_NUMBER, NON_MOVABLE_NUMBER};
            private int index = 0;

            @Override
            public int generate() {
                return positions[index++];
            }
        };

        cars.race(numberGenerator);
        assertThat(cars.getWinnerNames())
                .hasSize(2)
                .containsExactly("pobi", "crong");
    }

}
