package racingcar.controller;

import racingcar.service.RacingcarGameService;
import racingcar.service.RacingcarGameServiceImpl;
import racingcar.utility.TypeConverter;
import racingcar.view.InputHandler;
import racingcar.view.Printer;

public class RacingcarGameController {

    public static void startRacingcarGame() {
        Printer.printCarChoiceMessage();
        String carChoiceInputMessage = InputHandler.getInputMessage();

        Printer.printRoundChoiceMessage();
        String roundChoiceInputMessage = InputHandler.getInputMessage();

        int roundToRace = TypeConverter.convertStringToInt(roundChoiceInputMessage);

        playRacingcarGame(carChoiceInputMessage, roundToRace);
    }

    private static void playRacingcarGame(String carChoiceInputMessage, int roundToRace) {
        RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();
        racingcarGameService.generateCarsToRace(carChoiceInputMessage);
    }

}
