package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.repository.CarManager;
import racingcar.service.RaceService;
import racingcar.utils.InputHandler;
import racingcar.view.Output;

public class RaceController {

    public void run() {
        CarManager raceManager = new CarManager();
        Output output = new Output();
        InputHandler input = new InputHandler();

        output.carNamesInputPrompt();
        List<String> carNames = input.inputCarName();
        raceManager.createCarList(carNames);

        output.attemptNumberInputPrompt();
        String tryNumber = input.inputAttemptNumber();
        int attemptNumber = Integer.parseInt(tryNumber);

        RaceService raceService = new RaceService(raceManager, output);
        output.executionResultHeader();
        raceService.runRace(attemptNumber);

        List<String> winners = raceService.getWinners();
        output.printWinners(winners);
        Console.close();
    }
}