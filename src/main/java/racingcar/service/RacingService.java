package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Circuit;
import racingcar.dto.RacingResult;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public List<RacingResult> race(Circuit circuit) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(circuit.getCircuitSize());
        List<Car> racingResult = circuit.moveCars(randomNumbers);
        return racingResult.stream()
                .map(RacingResult::new)
                .toList();
    }

    public void announceWinners(Circuit circuit) {

    }
}