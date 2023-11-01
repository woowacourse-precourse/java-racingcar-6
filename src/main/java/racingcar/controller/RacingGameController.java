package racingcar.controller;

import racingcar.model.CarList;
import racingcar.service.RacingGameService;
import racingcar.validator.Validator;
import racingcar.view.RacingGameView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final RacingGameView racingGameView;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
        this.racingGameService = new RacingGameService();
    }

    public CarList inputCarName(){
        racingGameView.printInputCarName();
        List<String> names = racingGameService.splitStringToList(readLine());
        Validator.validateCarName(names);
        return racingGameService.makeCarList(names);
    }

    public void inputGameCnt(){
        racingGameView.printInputTryCount();
        String cnt = readLine();
    }
}
