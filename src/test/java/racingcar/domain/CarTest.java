package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @Test
    void 경주_자동차_이름_저장() {
        var carNames = List.of("Car1", "Car2", "Car3");
        car = new Car(carNames);

        RaceResultDTO raceResultDTO = car.oneCarRace();

        assertEquals(raceResultDTO.names(), carNames);
    }

    @Test
    void 경주_자동차_우승자_반환() {
        var carNames = List.of("Car1", "Car2", "Car3");
        car = new Car(carNames);

        car.oneCarRace();
        car.oneCarRace();
        car.oneCarRace();

        AtomicInteger farthestPosition = new AtomicInteger();
        RaceResultDTO raceResultDTO = car.oneCarRace();
        raceResultDTO.names()
                .stream()
                .filter(name -> raceResultDTO.positions().get(name) > farthestPosition.get())
                .forEach(name -> farthestPosition.set(raceResultDTO.positions().get(name)));

        var winners = raceResultDTO.names()
                        .stream()
                        .filter(name -> raceResultDTO.positions().get(name) == farthestPosition.get())
                        .collect(Collectors.toList());


        assertEquals(winners, car.getWinners());
    }
}

