package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingCarsTest {
    @Test
    void Car_리스트를_생성하라() throws Exception {
        List<String> carNames = Arrays.asList("pobi", "jun", "rao");
        RacingCars racingCars = new RacingCars(carNames);
        assertThat(racingCars.getCars().get(0).getName()).isEqualTo(carNames.get(0));
    }

    @Test
    void 자동차_이름이_알파벳이_아닌_경우_예외를_발생하라 () throws Exception {
        //given
        List<String> carNames = Arrays.asList("구구", "jun", "rao");
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars(carNames);;
        });
    }

    @Test
    void 자동차_이름에_공백이_포함된_경우_예외를_발생하라 () throws Exception {
        //given
        List<String> carNames1 = Arrays.asList("a a", "jun", "rao");
        List<String> carNames2 = Arrays.asList("   ", "jun", "rao");
        List<String> carNames3 = Arrays.asList(" ab", "jun", "rao");
        List<String> carNames4 = Arrays.asList("ab ", "jun", "rao");
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars(carNames1);;
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars(carNames2);;
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars(carNames3);;
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars(carNames4);;
        });
    }
}
