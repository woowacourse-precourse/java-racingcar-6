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
        List<MoveCondition> moveConditions = generateMoveConditions(circuit.getCircuitSize());
        List<Car> racedCars = circuit.raceCars(moveConditions);
        return convertToRacingResults(racedCars);
    }

    private List<MoveCondition> generateMoveConditions(int size) {
        return RandomNumbersGenerator.generate(size).stream()
                .map(MoveCondition::determineMoveCondition)
                .toList();
    }

    private List<RacingResult> convertToRacingResults(List<Car> racedCars) {
        return racedCars.stream()
                .map(RacingResult::new)
                .toList();
    }


    public Winners announceWinners(Circuit circuit) {
        List<String> winnerNames = circuit.findTopPositionCarNames();
        return new Winners(winnerNames);
    }
}