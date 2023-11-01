package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameCount;
import racingcar.model.RacingCarService;
import racingcar.util.RacingCarValidator;
import racingcar.view.OutPutView;

import java.util.List;
import java.util.Map;

import static racingcar.view.InputView.inputGameCount;
import static racingcar.view.InputView.inputJoinCarsName;

public class RacingCarController {
    OutPutView print = new OutPutView();
    RacingCarValidator validator = new RacingCarValidator();
    Cars cars = new Cars();
    GameCount gameCount = new GameCount();
    RacingCarService racingCarService = new RacingCarService();

    public void run() {
        setGamePlayer();
        setGameCount();
        executeResult();
        getHighStep();
        getResult();
    }

    public Map<String, Integer> setGamePlayer() {
        print.startMention();
        List<String> joinCarsName = inputJoinCarsName();
        validator.carNameLength(joinCarsName);
        return cars.setCarsData(joinCarsName);
    }

    public int setGameCount() {
        print.tryCount();
        String inputValue = inputGameCount();
        int number = validator.number(inputValue);
        return gameCount.setGameCount(number);
    }

    public Cars executeResult() {
        racingCarService.executeResult();
        print.executeResult(cars);
        return cars;
    }

    public void getHighStep() {
        gameCount.setHighStep();
    }

    public String getResult() {
        String winner = String.join(",", racingCarService.setWinner());
        print.winner(winner);
        return winner;
    }
}
