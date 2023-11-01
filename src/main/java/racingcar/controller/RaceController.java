package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.MoveCount;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private RaceService raceService;

    public void initRace() {
        OutputView.printRacingStart();
        String[] carNames = InputView.getCarNames();

        OutputView.printAskCount();
        MoveCount moveCnt = RaceService.getMoveCount();

        raceService = new RaceService(carNames, moveCnt);
    }

    public void run() {
        OutputView.printResult();
        List<Car> winners = raceService.run();
        List<String> winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.printFindWinner(winnersName);
    }

}
