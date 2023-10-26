package racingcar.service;

import racingcar.domain.Circuit;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public void race(Circuit circuit) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(circuit.getCircuitSize());
        circuit.moveCars(randomNumbers);
    }
}
