package racingcar.core;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void registerCars_메서드로_차_등록_테스트() {
        Racing racing = new Racing();

        List<String> carNames = List.of("pobi", "woni", "jun");
        racing.registerCarsByName(carNames);
    }

    @Test
    void registerCars_메서드로_차_등록_빈값_입력시_예외_반환() {
        Racing racing = new Racing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racing.registerCarsByName(List.of());
        });
    }

    @Test
    void registerCars_메서드로_차_등록_null_입력시_예외_반환() {
        Racing racing = new Racing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racing.registerCarsByName(null);
        });
    }

    @Test
    void registerRaceCount_메서드로_경기횟수_등록_테스트() {
        Racing racing = new Racing();

        racing.registerRaceCount(5);
    }

    @Test
    void registerRaceCount_메서드로_경기횟수_0일때_예외_반환() {
        Racing racing = new Racing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racing.registerRaceCount(0);
        });
    }

    @Test
    void registerRaceCount_메서드로_경기횟수_음수일때_예외_반환() {
        Racing racing = new Racing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racing.registerRaceCount(-1555);
        });
    }

    @Test
    void doRace_메서드_경기시작_테스트() {
        Racing racing = new Racing();
        List<String> carNames = List.of("pobi", "woni", "jun");
        racing.registerCarsByName(carNames);
        racing.registerRaceCount(5);

        racing.doRace();
    }

    @Test
    void doRace_메서드_경기_차량_등록_안할시_예외_발생() {
        Racing racing = new Racing();
        racing.registerRaceCount(5);

        Assertions.assertThrows(IllegalArgumentException.class, racing::doRace);
    }

    @Test
    void doRace_메서드_경기_횟수_등록_안할시_예외_발생() {
        Racing racing = new Racing();
        List<String> carNames = List.of("pobi", "woni", "jun");
        racing.registerCarsByName(carNames);

        Assertions.assertThrows(IllegalArgumentException.class, racing::doRace);
    }

    @Test
    void printWinner_메서드_테스트() {
        Racing racing = new Racing();
        List<String> carNames = List.of("pobi", "woni", "jun");
        racing.registerCarsByName(carNames);
        racing.registerRaceCount(5);
        racing.doRace();
        racing.printWinner();
    }

    @Test
    void printWinner_메서드_차_등록_안했을때_예외_발생() {
        Racing racing = new Racing();

        Assertions.assertThrows(IllegalArgumentException.class, racing::printWinner);
    }

    @Test
    void printWinner_메서드_경기_진행_안했을때_예외_발생() {
        Racing racing = new Racing();
        List<String> carNames = List.of("pobi", "woni", "jun");
        racing.registerCarsByName(carNames);
        racing.registerRaceCount(5);

        Assertions.assertThrows(IllegalArgumentException.class, racing::printWinner);
    }
}
