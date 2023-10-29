package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.FixedNumberGenerator;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

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
        long attemptCount = 5;
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
        racing = new Racing(cars, attemptCount, fixedNumberGenerator);

        // When
        racing.race();

        // Then
        HashMap<String, Integer> finalPositions = cars.getCars();
        assertThat(finalPositions.get("car1")).isEqualTo(1);
        assertThat(finalPositions.get("car2")).isEqualTo(1);
        assertThat(finalPositions.get("car3")).isEqualTo(1);
    }

}
