package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.service.RacingService;
import racingcar.view.OutputHandler;

public class RacingController {

    RacingService racingService = new RacingService();

    public void start() {
        initRacing();
        startRacing();
        endRacing();
    }

    private void initRacing() {
        OutputHandler.printRequestCarNames();
        List<String> carNames = getCarNames();

        OutputHandler.printRequestNumberOfAttempt();
        int numberOfAttempt = getNumberOfAttempt();

        racingService.initRacing(carNames, numberOfAttempt);
    }

    private void startRacing() {
        racingService.startRacing();
    }

    private void endRacing(){
        racingService.endRacing();
    }

    private List<String> getCarNames() {
        String userInput = Console.readLine();
        return Arrays.asList(userInput.split(","));
    }

    private int getNumberOfAttempt() {
        return Integer.parseInt(Console.readLine());
    }
}
