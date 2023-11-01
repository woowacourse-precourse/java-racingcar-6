package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameStatus;
import racingcar.domain.RandomNumbers;
import racingcar.service.RacingcarGameService;
import racingcar.service.RacingcarGameServiceImpl;
import racingcar.utility.RandomNumberGenerator;
import racingcar.utility.TypeConverter;
import racingcar.view.InputHandler;
import racingcar.view.PrintHandler;
import racingcar.view.Printer;

import static racingcar.domain.GameStatus.PLAYING;

public class RacingcarGameController {

    private static final RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();

    public static void startRacingcarGame() {
        Printer.printCarChoiceMessage();
        String carChoiceInputMessage = InputHandler.getInputMessage();

        Printer.printRoundChoiceMessage();
        String roundChoiceInputMessage = InputHandler.getInputMessage();

        int roundToRace = TypeConverter.convertStringToInt(roundChoiceInputMessage);
        Printer.printLineBreak();

        playRacingcarGame(carChoiceInputMessage, roundToRace);
    }

    private static void playRacingcarGame(String carChoiceInputMessage, int roundToRace) {
        GameStatus gameStatus = PLAYING;

        Cars cars = racingcarGameService.generateCarsToRace(carChoiceInputMessage);

        Printer.printResultHeadMessage();

        while (gameStatus.isGamePlaying()) {
            proceedEachRound(cars, gameStatus);
        }
    }

    private static void proceedEachRound(Cars cars, GameStatus gameStatus) {
        RandomNumbers randomNumbers = new RandomNumbers(RandomNumberGenerator.generateRandomNumbers(cars.size()));
        racingcarGameService.playOneRound(cars, randomNumbers);
        PrintHandler.printResultOfGame(cars);
    }

}
