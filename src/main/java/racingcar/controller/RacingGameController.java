package racingcar.controller;

import racingcar.model.CarList;
import service.RacingGameService;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }

    CarList inputCarName(){
        String carNames = readLine();
        return racingGameService.makeCarList(carNames);
    }
}
