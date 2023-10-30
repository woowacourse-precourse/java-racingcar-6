package racingcar.controller;

import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.dao.RaceDAO;
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
        RandomNumberGenerator generator = new RandomNumberGenerator();
        while(raceData.getAttemptNumber()>0){
            generator.NumberGenrate();
            GameService.raceDataSave(raceData.getAttemptNumber()-1);
            raceData=RaceDAO.loadAll();
        }


        generator.NumberGenrate();
    }
}
