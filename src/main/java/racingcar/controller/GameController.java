package racingcar.controller;

import racingcar.common.exception.ConfirmException;
import racingcar.domain.FindMaxScore;
import racingcar.domain.FindWinnerCar;
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
        OutputAboutGame.printCarInputPhrase();

        List<String> carNames = InputAboutGame.InputCarNames();

        ConfirmException.confirmCarName(carNames);
        GameService.carsDataSave(carNames);

        OutputAboutGame.printAttemptInputPhrase();
        GameService.raceDataSave(InputAboutGame.InputAttempt());

        RaceEntity raceData = RaceDAO.loadAll();
        List<CarEntity> carsData = CarDAO.loadAll();

        OutputAboutGame.printResultIntroducePhrase();

        while (raceData.getAttemptNumber() > 0) {
            JudgeMoveCar.moveCar(carsData);
            OutputAboutGame.printCurrentSituation(CarDAO.loadAll());
            GameService.raceDataSave(raceData.getAttemptNumber() - 1);
            raceData = RaceDAO.loadAll();
        }

        List<CarEntity> winner = FindWinnerCar.equalMaxScroe(
                CarDAO.loadAll(), FindMaxScore.findMax(CarDAO.loadAll())
        );

        OutputAboutGame.printWinner(winner);
    }
}
