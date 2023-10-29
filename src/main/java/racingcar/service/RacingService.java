package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.MoveCondition;
import racingcar.domain.Circuit;
import racingcar.dto.RacingResult;
import racingcar.dto.Winners;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public List<RacingResult> race(Circuit circuit) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(circuit.getCircuitSize());

        List<MoveCondition> moveConditionList = randomNumbers.stream()
                .map(MoveCondition::convertToCarStatus)
                .toList();

        List<Car> racingResult = circuit.moveCars(moveConditionList);
        return racingResult.stream()
                .map(RacingResult::new)
                .toList();
    }

    public Winners announceWinners(Circuit circuit) {
        List<String> winnerNames = circuit.findTopPositionCarNames();
        return new Winners(winnerNames);
    }
}