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

    public Controller(RacingGameService racingGameService, CarService carService) {
        this.racingGameService = racingGameService;
        this.carService = carService;
    }

    public void startRacingGame() {
        List<Long> carsIdList = getCarsIdList();
        int maxGameCount = getMaxGameCount();
        RacingGame racingGame = racingGameService.createNewGame(carsIdList, maxGameCount);
    }

    private int getMaxGameCount() {
        String gameCountString = getGameCountStringByUserInput();
        return Parser.parseNumberOfCount(gameCountString);
    }

    private String getGameCountStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }

    private List<Long> getCarsIdList() {
        String nameString = getNameStringByUserInput();
        List<String> carNameList = Parser.parseCarNames(nameString);
        return saveCarsInRepository(carNameList);
    }

    private List<Long> saveCarsInRepository(List<String> carNameList) {
        List<Long> carIdList = new ArrayList<>();
        Long id = 1L;
        for (String s : carNameList) {
            carService.join(new Car(s, id));
            carIdList.add(id);
            id += 1;
        }
        return carIdList;
    }

    private String getNameStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }
}
