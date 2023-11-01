package racingcar.controller;

import racingcar.domain.*;
import racingcar.service.RacingcarGameService;
import racingcar.service.RacingcarGameServiceImpl;
import racingcar.utility.RandomNumberGenerator;
import racingcar.utility.RankingComputer;
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
        Cars cars = racingcarGameService.generateCarsToRace(carChoiceInputMessage);

        Printer.printRoundChoiceMessage();
        String roundChoiceInputMessage = InputHandler.getInputMessage();
        Printer.printLineBreak();

        int roundToRace = TypeConverter.convertStringToInt(roundChoiceInputMessage);

        playRacingcarGame(cars, roundToRace);
    }

    private static void playRacingcarGame(Cars cars, int roundToRace) {
        GameStatus gameStatus = PLAYING;

        Printer.printResultHeadMessage();

        Round round = new Round();

        while (gameStatus.isGamePlaying()) {
            round.addRound();
            proceedEachRound(cars);

            gameStatus = round.checkIfGameIsOver(roundToRace);
        }

        Winners winners = RankingComputer.computeWinners(cars);
        PrintHandler.printFinalResultOfGame(winners);
    }

    private static void proceedEachRound(Cars cars) {
        RandomNumbers randomNumbers = new RandomNumbers(RandomNumberGenerator.generateRandomNumbers(cars.size()));
        racingcarGameService.playOneRound(cars, randomNumbers);
        PrintHandler.printResultOfGame(cars);
    }

}
