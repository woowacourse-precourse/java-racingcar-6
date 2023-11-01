package racingcar.service;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.ControlTower;
import racingcar.domain.GameRecord;
import racingcar.dto.ControlTowerDto;

public class ControlTowerService {

    private final ControlTower controlTower;
    private final GameRecord gameRecord;

    public ControlTowerService(ControlTower controlTower, GameRecord gameRecord) {
        this.controlTower = controlTower;
        this.gameRecord = gameRecord;
    }

    public Map<Integer, List<String>> startRacingGame(ControlTowerDto controlTowerDto) {

        return controlTower.startRacing(controlTowerDto.getCars(), controlTowerDto.getRoundNumber());
    }

    public List<String> judgmentWinner(List<Car> carList) {
        return gameRecord.findWinner(carList);
    }
}
