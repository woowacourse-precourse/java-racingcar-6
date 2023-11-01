package racingcar.controller;

import racingcar.service.RacingcarGameService;
import racingcar.service.RacingcarGameServiceImpl;
import racingcar.view.InputHandler;
import racingcar.view.Printer;

public class RacingcarController {

    public static void startRacingcarGame() {
        Printer.printCarChoiceMessage();
        String carChoiceInputMessage = InputHandler.getInputMessage();

        Printer.printRoundChoiceMessage();
        String roundChoiceInputMessage = InputHandler.getInputMessage();

        playRacingcarGame(carChoiceInputMessage, roundChoiceInputMessage);
    }

    private static void playRacingcarGame(String carChoiceInputMessage, String roundChoiceInputMessage) {
        RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();
        racingcarGameService.generateCarsToRace(carChoiceInputMessage);
    }

}
