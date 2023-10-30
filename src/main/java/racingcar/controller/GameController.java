package racingcar.controller;

import racingcar.domain.JudgeMoveCar;
import racingcar.domain.dao.CarDAO;
import racingcar.domain.dao.RaceDAO;
import racingcar.domain.entity.CarEntity;
import racingcar.domain.entity.RaceEntity;
import racingcar.service.GameService;
import racingcar.view.InputAboutGame;
import racingcar.view.OutputAboutGame;

import java.util.List;

public class GameController {
    public GameController() {
        this.run();
    }

    public void run() {
        OutputAboutGame.PrintCarInputPhrase();
        GameService.carsDataSave(InputAboutGame.InputCarNames());
        OutputAboutGame.PrintAttemptInputPhrase();
        GameService.raceDataSave(InputAboutGame.InputAttempt());
        RaceEntity raceData=RaceDAO.loadAll();
        List<CarEntity> carsData= CarDAO.loadAll();
        while(raceData.getAttemptNumber()>0){
            JudgeMoveCar.MoveCar(carsData);
            GameService.raceDataSave(raceData.getAttemptNumber()-1);
            raceData=RaceDAO.loadAll();
        }

    }
}
