package racingcar.service;

import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private final MoveService moveService;
    private final WinnerService winnerService;

    public RacingGameService(MoveService moveService, WinnerService winnerService) {
        this.moveService = moveService;
        this.winnerService = winnerService;
    }

    public List<Car> initializeRacingCars(List<String> carNames, int triesCount) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            List<Boolean> movementFlags = moveService.createMovementFlags(triesCount);
            racingCars.add(new Car(carName, movementFlags));
        }
        return racingCars;
    }

    public List<Car> findWinners(List<Car> racingCars) {
        return winnerService.findWinners(racingCars);
    }
}
