package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.service.RacingService;
import racingcar.view.OutputHandler;

public class RacingController {

    RacingService racingService = new RacingService();

    public void start() {
        initGame();
        startGame();
    }

    private void initGame() {
        OutputHandler.printRequestCarNames();
        List<String> carNames = getCarNames();

        OutputHandler.printRequestNumberOfAttempt();
        int numberOfAttempt = getNumberOfAttempt();

        racingService.initGame(carNames, numberOfAttempt);
    }

    private void startGame(){
        racingService.startGame();
    }

    private List<String> getCarNames() {
        String userInput = Console.readLine();
        return Arrays.asList(userInput.split(","));
    }
    private int getNumberOfAttempt(){
        return Integer.parseInt(Console.readLine());
    }
}
