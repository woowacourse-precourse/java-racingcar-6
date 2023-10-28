package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingCarsTest {
    List<String> carNames = Arrays.asList("pobi", "jun", "rao");
    RacingCars racingCars = new RacingCars(carNames);
    @Test
    void Car_리스트를_생성하라() throws Exception {
        assertThat(racingCars.getCars().get(0).getName()).isEqualTo(carNames.get(0));
    }
}
