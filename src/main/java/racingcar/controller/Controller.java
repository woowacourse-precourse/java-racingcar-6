package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

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

    private List<Long> getCarsIdList() {
        String nameString = getNameStringByUserInput();
    }

    private String getNameStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }
}
