package racingcar.service;

import racingcar.domain.Circuit;
import racingcar.dto.RacingResult;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public List<RacingResult> race(Circuit circuit) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(circuit.getCircuitSize());
        return circuit.moveCars(randomNumbers).stream()
                .map(RacingResult::new)
                .toList();
    }
}
