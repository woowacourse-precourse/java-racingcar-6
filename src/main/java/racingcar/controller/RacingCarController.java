package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameCount;
import racingcar.model.RacingCarService;
import racingcar.util.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

import java.util.List;
import java.util.Map;

public class RacingCarController {
    OutPutView print = new OutPutView();
    InputView input = new InputView();
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
        List<String> joinCarsName = input.joinCarsName();
        validator.carNameLength(joinCarsName);
        return cars.setCarsData(joinCarsName);
    }

    public int setGameCount() {
        print.tryCount();
        String inputValue = input.GameCount();
        int number = validator.number(inputValue);
        return gameCount.setGameCount(number);
    }

    public Cars executeResult() {
        racingCarService.executeResult();
        print.executeResult(cars);
        return cars;
    }

    public int getHighStep() {
        return gameCount.setHighStep();
    }

    public String getResult() {
        String winner = String.join(",", racingCarService.setWinner());
        print.winner(winner);
        return winner;
    }
}
