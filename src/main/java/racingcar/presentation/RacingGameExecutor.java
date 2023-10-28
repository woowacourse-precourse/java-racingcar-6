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
        String racingCarsNameInput = receiveRacingCars();
        List<String> racingCarsNames = Arrays.asList(racingCarsNameInput.split(ConstStandard.CRITERIA_SEPARATE));
        racingCarsNames.forEach(String::trim);

        Long trial = Long.valueOf(receiveTrial());

        RacingGame racingGame = new RacingGame(trial, racingCarsNames);
        racingGame.start();
    }

    private String receiveRacingCars() {
        Printer.printLine(Command.ASK_CAR_NAMES.getMessage());
        return racingCarsReader.read();
    }

    private String receiveTrial() {
        Printer.printLine(Command.ASK_TRIAL.getMessage());
        return trialReader.read();
    }
}
