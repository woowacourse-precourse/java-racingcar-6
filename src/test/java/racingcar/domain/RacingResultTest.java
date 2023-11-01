package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;

class RacingResultTest {

    @Test
    void findWinner() {
        // given
        Car pony = new Car("pony");
        Car zon = new Car("zon");
        RacingCars racingCars = new RacingCars(Arrays.asList(pony, zon));

        // when
        pony.move(4);
        pony.move(9);
        zon.move(0);
        zon.move(5);
        int ponyPosition = pony.getPosition();
        int zonPosition = zon.getPosition();
        RacingResult racingResult = new RacingResult(racingCars.submitCarStatuses());
        String winner = racingResult.findWinner();

        // then
        assertThat(ponyPosition).isEqualTo(2);
        assertThat(zonPosition).isEqualTo(1);
        assertThat(winner).isEqualTo("pony");
    }

    @Test
    void getCarStatuses() {
        // given
        Car pony = new Car("pony");
        Car zon = new Car("zon");
        RacingCars racingCars = new RacingCars(Arrays.asList(pony, zon));

        // when
        pony.move(1);
        zon.move(5);
        RacingResult racingResult = new RacingResult(racingCars.submitCarStatuses());
        List<CarStatusDto> carStatuses = racingResult.getCarStatuses();

        // then
        assertThat(carStatuses)
                .extracting(CarStatusDto::name)
                .containsExactly("pony", "zon");

        assertThat(carStatuses)
                .extracting(CarStatusDto::position)
                .containsExactly(0, 1);
    }
}