package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.FixedNumberGenerator;

public class RacingTest {

    private static final int MOVE_BOUNDARY = 4;
    private static final int NO_MOVE_BOUNDARY = 3;
    private static final long ATTEMPT_COUNT = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int MOVED_POSITION = 1;

    private Cars cars;
    private Racing racing;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCars(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("랜덤숫자 입력 가정 - 4입력시 전진해야됨")
    void race_whenRandomNumberIs4_shouldMoveCars() {
        // Given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(MOVE_BOUNDARY);
        racing = new Racing(cars, ATTEMPT_COUNT, fixedNumberGenerator);

        // When
        racing.race();

        // Then
        HashMap<String, Integer> finalPositions = cars.getCars();
        assertThat(finalPositions.get("car1")).isEqualTo(MOVED_POSITION);
        assertThat(finalPositions.get("car2")).isEqualTo(MOVED_POSITION);
        assertThat(finalPositions.get("car3")).isEqualTo(MOVED_POSITION);
    }

    @Test
    @DisplayName("랜덤숫자 입력 가정 - 3입력시 전진하면 안됨")
    void race_whenRandomNumberIs3_shouldNotMoveCars() {
        // Given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(NO_MOVE_BOUNDARY);
        racing = new Racing(cars, ATTEMPT_COUNT, fixedNumberGenerator);

        // When
        racing.race();

        // Then
        HashMap<String, Integer> finalPositions = cars.getCars();
        assertThat(finalPositions.get("car1")).isEqualTo(INITIAL_POSITION);
        assertThat(finalPositions.get("car2")).isEqualTo(INITIAL_POSITION);
        assertThat(finalPositions.get("car3")).isEqualTo(INITIAL_POSITION);
    }
}

