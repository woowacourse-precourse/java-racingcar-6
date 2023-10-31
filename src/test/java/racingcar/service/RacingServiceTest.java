package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

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
        List<Car> roundResult = racingService.playSingleRound(cars);

        // then
        roundResult.forEach(car ->
                assertThat(car.getMove()).isBetween(0, 9)
        );

        int maxDistance = getMaxDistance(cars);
        cars.stream().filter(car -> car.getMove() == maxDistance)
                .forEach(car -> assertThat(car.getWinCount()).isEqualTo(1));
    }

    private static int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    @DisplayName("자동차의 우승 횟수를 판단해 최종 우승자 List를 생성한다.")
    @Test
    void findByVictoryPlayers() {
        // given
        Car pobi = Car.createCar("pobi");
        Car woni = Car.createCar("woni");
        Car jun = Car.createCar("jun");

        List<Car> cars = new ArrayList<>(List.of(pobi, woni, jun));
        cars.get(0).plusWinCount();
        cars.get(2).plusWinCount();

        // when
        List<String> victoryCars =
                racingService.findByVictoryPlayers(cars);

        // then
        assertThat(victoryCars).contains("pobi", "jun");
    }
}