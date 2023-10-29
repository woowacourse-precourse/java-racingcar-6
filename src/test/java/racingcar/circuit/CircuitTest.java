package racingcar.circuit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.result.RacingCarResult;
import racingcar.generator.NumberGenerator;

class CircuitTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        Car car1 = new Car("one");
        Car car2 = new Car("two");
        Car car3 = new Car("three");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @DisplayName("서킷 경기장의 모든 자동차에게 난수를 전달한다.")
    @Test
    void tryRacingGame() {
        Circuit circuit = getTestCircuit();
        cars.forEach(circuit::addRacingCar);

        circuit.tryRacingGame();
        List<RacingCarResult> results = summarizeRacingResult(circuit.getCars());
        List<Integer> racingCarLocations = results.stream().map(RacingCarResult::location).toList();

        Assertions.assertThat(racingCarLocations).containsExactly(1, 0, 1);
    }

    private List<RacingCarResult> summarizeRacingResult(List<Car> cars) {
        return cars.stream().map(Car::toResult).toList();
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
