package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();
    private final List<String> carNameList = List.of("car", "benz", "audi", "fox");
    @Test
    void prepareCars_결과_이름_동일() {
        Cars cars = racingCarService.prepareCars(carNameList);

        List<Car> carList = cars.getCars();
        List<String> prepareCarNameList = carList.stream()
            .map(Car::getName)
            .toList();

        assertThat(carNameList).isEqualTo(prepareCarNameList);
        assertThat(carNameList.size()).isEqualTo(prepareCarNameList.size());
    }

    @Test
    void startRace() {
    }

    @Test
    void determineRaceResult() {
    }
}