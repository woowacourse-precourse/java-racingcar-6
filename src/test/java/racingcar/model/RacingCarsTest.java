package racingcar.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarDto;
import racingcar.model.number.InputNumberGenerator;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = RacingCars.createCars(new String[]{"car1", "car2"});
        racingCars.move(new InputNumberGenerator(5));
    }

    @Test
    void 자동차의_현재_상태를_확인() {
        List<CarDto> expectedStatus = Arrays.asList(new CarDto("car1", 1),
                new CarDto("car2", 1));
        List<CarDto> actualStatus = racingCars.getStatus();

        Assertions.assertThat(actualStatus).containsExactlyElementsOf(expectedStatus);
    }

    @Test
    void 가장_앞에_있는_자동차의_위치를_반환() {
        racingCars.move(new InputNumberGenerator(6));
        int maxPositions = racingCars.getMaxPositions();

        Assertions.assertThat(maxPositions).isEqualTo(2);
    }
}