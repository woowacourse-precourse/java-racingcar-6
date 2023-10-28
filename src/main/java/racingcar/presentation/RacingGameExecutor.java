package racingcar.presentation;

import racingcar.application.RacingGame;
import racingcar.util.channel.Printer;
import racingcar.util.channel.ReaderForRacingCars;
import racingcar.util.channel.ReaderForTrial;
import racingcar.util.constant.ConstStandard;
import racingcar.util.enums.Command;

import java.util.Arrays;
import java.util.List;

public class RacingGameExecutor {
    private final ReaderForRacingCars racingCarsReader;
    private final ReaderForTrial trialReader;

    public RacingGameExecutor() {
        this.racingCarsReader = new ReaderForRacingCars();
        this.trialReader = new ReaderForTrial();
    }

    public void execute() {
        List<String> racingCarsNames = receiveRacingCarNames();
        Long trial = receiveTrial();

        RacingGame racingGame = new RacingGame(trial, racingCarsNames);

        racingGame.start();
    }

    private List<String> receiveRacingCarNames() {
        Printer.printLine(Command.ASK_CAR_NAMES.getMessage());
        String carNamesInput = racingCarsReader.read();

        List<String> carNames = Arrays.asList(carNamesInput.split(ConstStandard.CRITERIA_SEPARATE));
        carNames.forEach(String::trim);

        return carNames;
    }

    private Long receiveTrial() {
        Printer.printLine(Command.ASK_TRIAL.getMessage());

        String trialInput = trialReader.read();

        return Long.valueOf(trialInput);
    }
}
