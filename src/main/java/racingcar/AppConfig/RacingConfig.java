package racingcar.AppConfig;

import racingcar.domain.ControlTower;
import racingcar.domain.GameRecord;
import racingcar.domain.Referee;
import racingcar.service.ControlTowerService;
import racingcar.service.RefereeService;

public class RacingConfig {
    public RefereeService refereeService() {
        return new RefereeService(referee());
    }

    public Referee referee() {
        return new Referee();
    }

    public ControlTowerService controlTowerService() {
        return new ControlTowerService(controlTower(), gameRecord());
    }

    public ControlTower controlTower() {
        return new ControlTower();
    }

    public GameRecord gameRecord() {
        return new GameRecord();
    }
}
