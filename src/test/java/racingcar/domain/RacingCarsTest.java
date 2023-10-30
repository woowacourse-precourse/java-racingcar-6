package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;

class RacingCarsTest {

    @Test
    void move() {
        // given
        Car pony = new Car("pony");
        Car zon = new Car("zon");
        RacingCars racingCars = new RacingCars(Arrays.asList(pony, zon));

        // when
        for (int i = 0; i < 10; i++) {
            racingCars.move();
        }
        int curPonyPosition = pony.getPosition();
        int curZonPosition = zon.getPosition();

        pony.move(0);
        zon.move(4);
        int nextPonyPosition = pony.getPosition();
        int nextZonPosition = zon.getPosition();

        // then
        assertThat(nextPonyPosition).isEqualTo(curPonyPosition);
        assertThat(nextZonPosition).isEqualTo(curZonPosition + 1);
    }

    @Test
    void submitCarStatuses() {
        // given
        Car car1 = new Car("pony");
        Car car2 = new Car("zon");
        RacingCars racingCars = new RacingCars(Arrays.asList(car1, car2));

        // when
        RacingResult racingResult =  new RacingResult(racingCars.submitCarStatuses());

        // then
        assertThat(racingResult.getCarStatuses())
                .extracting(CarStatusDto::name)
                .containsExactly("pony", "zon");
    }
}