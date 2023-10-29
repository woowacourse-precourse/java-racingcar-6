package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarStatus;
import racingcar.domain.Circuit;
import racingcar.dto.RacingResult;
import racingcar.dto.Winners;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public List<RacingResult> race(Circuit circuit) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(circuit.getCircuitSize());

        List<CarStatus> carStatusList = randomNumbers.stream()
                .map(CarStatus::convertToCarStatus)
                .toList();

        List<Car> racingResult = circuit.moveCars(carStatusList);
        return racingResult.stream()
                .map(RacingResult::new)
                .toList();
    }

    public Winners announceWinners(Circuit circuit) {
        List<String> winnerNames = circuit.findTopPositionCarNames();
        return new Winners(winnerNames);
    }
}