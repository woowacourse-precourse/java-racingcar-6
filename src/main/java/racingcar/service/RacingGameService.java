package racingcar.service;

import racingcar.vo.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private final MoveStrategy moveStrategy;
    private final WinnerService winnerService;

    public RacingGameService(MoveStrategy moveStrategy, WinnerService winnerService) {
        this.moveStrategy = moveStrategy;
        this.winnerService = winnerService;
    }

    public List<Car> initializeRacingCars(List<String> carNames, int triesCount) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            List<Boolean> movementFlags = moveStrategy.createMovementFlags(triesCount);
            racingCars.add(new Car(carName, movementFlags));
        }
        return racingCars;
    }

    public List<Car> findWinners(List<Car> racingCars) {
        return winnerService.findWinners(racingCars);
    }
}
