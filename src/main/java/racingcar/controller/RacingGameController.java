package racingcar.controller;

import racingcar.model.CarList;
import racingcar.service.RacingGameService;
import racingcar.validator.Validator;
import racingcar.view.RacingGameView;

import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final RacingGameView racingGameView;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
        this.racingGameService = new RacingGameService();
    }

    public void play(){
        CarList carList = inputCarName();
        int gameCnt = inputGameCnt();
        racingGameView.printGameResult();

        IntStream.range(0, gameCnt).forEach(round -> {
        carList.getCarList().stream()
                        .forEach(car -> racingGameService.determineMoveForward(car));
        racingGameView.printMoveDist(carList);
        });

        racingGameView.printWinners(carList);
    }

    public CarList inputCarName(){
        racingGameView.printInputCarName();
        List<String> names = racingGameService.splitStringToList(readLine());
        Validator.validateCarName(names);
        return racingGameService.makeCarList(names);
    }

    public int inputGameCnt(){
        racingGameView.printInputTryCount();
        String cnt = readLine();
        Validator.validateTryCnt(cnt);
        return Integer.parseInt(cnt);
    }
}
