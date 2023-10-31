package racingcar.service;

import java.util.List;
import java.util.Map;
import racingcar.domain.ControlTower;
import racingcar.dto.ControlTowerDto;

public class ControlTowerService {

    private final ControlTower controlTower;

    public ControlTowerService(ControlTower controlTower) {
        this.controlTower = controlTower;
    }

    public Map<Integer, List<String>> startRacingGame(ControlTowerDto controlTowerDto) {

        return controlTower.startRacing(controlTowerDto.getCars(), controlTowerDto.getRoundNumber());
    }
}
