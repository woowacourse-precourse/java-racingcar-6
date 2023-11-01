package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;
    private List<String> carNames = List.of("Car1", "Car2", "Car3");

    @BeforeEach
    void 자동차_객체_생성() {
        carRacing = new CarRacing(carNames);
    }

    @Test
    void 경주_자동차_이름_저장() {
        RacingResultDTO raceResultDTO = carRacing.toDTO();

        assertEquals(raceResultDTO.names(), carNames);
    }

    @Test
    void 경주_자동차_레이스_결과_이름크기_위치크기_같음() {
        RacingResultDTO raceResultDTO = carRacing.toDTO();

        var names = raceResultDTO.names();
        var positions = raceResultDTO.positions();

        assertEquals(names.size(), positions.size());
    }

    @Test
    void 경주_자동차_우승자_반환() {
        carRacing.oneRacing();
        carRacing.oneRacing();
        carRacing.oneRacing();

        AtomicInteger farthestPosition = new AtomicInteger();
        RacingResultDTO raceResultDTO = carRacing.toDTO();
        var names = raceResultDTO.names();
        var positions = raceResultDTO.positions();

        IntStream.range(0, names.size())
                .filter(index -> positions.get(index) > farthestPosition.get())
                .forEach(index -> farthestPosition.set(positions.get(index)));

        var winners = IntStream.range(0, names.size())
                .filter(index -> positions.get(index) == farthestPosition.get())
                .mapToObj(names::get)
                .collect(Collectors.toList());

        assertEquals(winners, carRacing.getWinners());
    }
}

