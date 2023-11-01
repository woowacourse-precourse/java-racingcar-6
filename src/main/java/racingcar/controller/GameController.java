package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.ControlTowerDto;
import racingcar.dto.GameRecordDto;
import racingcar.service.ControlTowerService;
import racingcar.service.RefereeService;

public class GameController {

    private final RefereeService refereeService;
    private final ControlTowerService controlTowerService;

    public GameController(RefereeService refereeService, ControlTowerService controlTowerService) {
        this.refereeService = refereeService;
        this.controlTowerService = controlTowerService;
    }

    public List<Car> addCarNames(String inputCarNames) {
        return refereeService.inputCarNames(inputCarNames);
    }

    public int addRoundNumber(String inputRoundNumber) {
        return refereeService.saveRoundNumber(inputRoundNumber);
    }

    public GameRecordDto startRacingGame(List<Car> carList, int roundNumber) {
        return controlTowerService.startRacingGame(new ControlTowerDto(carList, roundNumber));
    }

    public List<String> addResultRecord(List<Car> carList) {
        return controlTowerService.judgmentWinner(carList);
    }
}
