package racingcar.domain.race.manager;

import org.junit.jupiter.api.Test;
import racingcar.domain.race.car.Car;
import racingcar.domain.race.car.Engine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacersRegistryTest {

    CarRacersRegistry carRacersRegistry = CarRacersRegistry.newInstance();

    @Test
    void 자동차_명단_등록_테스트() {
        // given
        Car car = Car.of("pobi", Engine.newInstance());

        // when
        carRacersRegistry.registerRacer(car);

        // then
        List<Car> racersList = carRacersRegistry.getRacersList();
        assertThat(car)
                .isSameAs(racersList.get(0));
    }

    @Test
    void 자동차_명단_방어적_복사_테스트() {
        // given
        Car car = Car.of("pobi", Engine.newInstance());

        // when
        carRacersRegistry.registerRacer(car);
        List<Car> racersList = carRacersRegistry.getRacersList();

        // then
        racersList.remove(0);
        assertThat(racersList.size())
                .isEqualTo(0);

        racersList = carRacersRegistry.getRacersList();
        assertThat(racersList.size())
                .isEqualTo(1);
    }

}