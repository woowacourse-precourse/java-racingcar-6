package racingcar.controller;

import racingcar.service.RacingcarGameService;
import racingcar.service.RacingcarGameServiceImpl;
import racingcar.view.InputHandler;
import racingcar.view.Printer;

public class RacingcarController {

    public static void startRacingcarGame() {
        Printer.printCarChoiceMessage();
        String inputMessage = InputHandler.getInputMessage();

        playRacingcarGame(inputMessage);
    }

    private static void playRacingcarGame(String inputMessage) {
        RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();
        racingcarGameService.generateCarsToRace(inputMessage);
    }

}
