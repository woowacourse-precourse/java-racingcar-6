package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("RacingCars 생성")
    void createRacingCars() {
        // given
        String inputtedCarNames = "pobi,woni,jun";
        CarsDto carsDto = new CarsDto(inputtedCarNames);

        // when
        RacingCars racingCars = new RacingCars(carsDto);

        // then
        assertThat(racingCars).isExactlyInstanceOf(RacingCars.class);
    }
}