package racingcar.circuit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.domain.result.RacingCarResult;
import racingcar.domain.result.RacingGameStatistics;
import racingcar.generator.NumberGenerator;

class CircuitTest {

    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("one");
        RacingCar racingCar2 = new RacingCar("two");
        RacingCar racingCar3 = new RacingCar("three");
        racingCars.add(racingCar1);
        racingCars.add(racingCar2);
        racingCars.add(racingCar3);
    }

    @DisplayName("서킷 경기장의 모든 자동차에게 난수를 전달한다.")
    @Test
    void tryRacingGame() {
        Circuit circuit = getTestCircuit();
        racingCars.forEach(circuit::addRacingCar);

        circuit.moveRacingCars();
        RacingGameStatistics results = circuit.getRacingGameStatistics();
        List<RacingCarResult> racingCarResults = results.racingCarResults();
        List<Integer> racingCarLocations = racingCarResults.stream().map(RacingCarResult::location).toList();

        Assertions.assertThat(racingCarLocations).containsExactly(1, 0, 1);
    }

    private Circuit getTestCircuit() {
        Queue<Integer> numbers = new ArrayDeque<>(List.of(4, 0, 5));
        TestNumberGenerator numberGenerator = new TestNumberGenerator(numbers);
        return new Circuit(numberGenerator);
    }

    private record TestNumberGenerator(Queue<Integer> numbers) implements NumberGenerator {

        @Override
        public Integer generate() {
            return numbers.poll();
        }
    }
}
