package racingcar.presentation;

import racingcar.application.RacingService;
import racingcar.domain.model.Car;
import racingcar.utils.IOHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final RacingService racingService;
    private final InputValidator inputValidator;
    private final RacingGameOutputHandler outputHandler;

    public RacingController() {
        this.racingService = RacingService.getInstance();
        this.inputValidator = InputValidator.getInstance();
        this.outputHandler = RacingGameOutputHandler.getInstance();
    }

    public void startGame() {
        outputHandler.printRaceStartMessage();
        String carNamesInput = IOHandler.readAndPrintInput();
        inputValidator.validateCarNames(carNamesInput);
        List<Car> carList = Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        outputHandler.printTryCountMessage();
        String tryCountInput = IOHandler.readAndPrintInput();
        inputValidator.validateTryCount(tryCountInput);
        int tryCount = Integer.parseInt(tryCountInput);

        outputHandler.printRaceResultHeader();

        for (int i = 0; i < tryCount; i++) {
            List<Car> roundResult = racingService.playRound(carList);
            outputHandler.printRaceResult(roundResult);
        }

        List<Car> winners = racingService.getWinners(carList);
        outputHandler.printWinners(winners);
    }
}
