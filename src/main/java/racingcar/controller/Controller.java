package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import utils.Parser;

public class Controller {
    private final RacingGameService racingGameService;
    private final CarService carService;

    private Long racingGameId = 1L;
    private Long carId = 1L;

    public Controller(RacingGameService racingGameService, CarService carService) {
        this.racingGameService = racingGameService;
        this.carService = carService;
    }

    public void initRacingGame() {
        RacingGame racingGame = racingGameService.createNewGame(getCarsIdList(), getGameCount(), racingGameId);
        racingGameId += 1;
        play(racingGame);
    }

    private void play(RacingGame racingGame) {
        while (!racingGameService.isGameFinish(racingGame.getId())) {
            
        }
    }

    private int getGameCount() {
        String gameCountString = getGameCountStringByUserInput();
        return Parser.parseNumberOfCount(gameCountString);
    }

    private List<Long> getCarsIdList() {
        String nameString = getNameStringByUserInput();
        List<String> carNameList = Parser.parseCarNames(nameString);
        return saveCarsInRepository(carNameList);
    }

    private List<Long> saveCarsInRepository(List<String> carNameList) {
        List<Long> carIdList = new ArrayList<>();
        for (String s : carNameList) {
            carService.join(new Car(s, carId));
            carIdList.add(carId);
            carId += 1;
        }
        return carIdList;
    }

    private String getGameCountStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }

    private String getNameStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }
}
