package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingServiceTest {
    private final RacingService racingService = new RacingService();

    @DisplayName("입력받은 자동차의 이름으로 자동차 객체 리스트를 생성한다.")
    @Test
    void createCarList() {
        // given
        String[] names = new String[]{"pobi", "woni", "jun"};

        // when
        List<Car> carList = racingService.createCarList(names);

        // then
        assertThat(carList)
                .extracting("name", "winCount")
                .containsExactly(
                        tuple("pobi", 0),
                        tuple("woni", 0),
                        tuple("jun", 0)
                );
    }

    @DisplayName("각각의 자동차가 랜덤한 수로 움직인다.")
    @Test
    void playRacingCar() {
        // given
        Car pobi = Car.createCar("pobi");
        Car woni = Car.createCar("woni");
        Car jun = Car.createCar("jun");
        List<Car> cars = List.of(pobi, woni, jun);

        // when
        Map<String, Integer> result = racingService.playRacingCar(cars);

        // then
        result.values().forEach(score ->
                assertThat(score).isBetween(0, 9)
        );

        int maxScore = Collections.max(result.values());
        cars.stream().filter(car -> result.get(car.getName()) == maxScore)
                .forEach(car -> assertThat(car.getWinCount()).isEqualTo(1));
    }
}