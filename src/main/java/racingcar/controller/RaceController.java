package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.RaceAttempts;
import racingcar.domain.RaceParticipants;
import racingcar.domain.RaceWinners;
import racingcar.domain.RacingCar;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.view.console.InputView;
import racingcar.view.console.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RaceParticipants raceParticipants = setRaceParticipants();
        RaceAttempts raceAttempts = setRaceAttempts();
        RaceWinners raceWinners = runRaceAndGetWinners(raceParticipants, raceAttempts);
        displayRaceWinners(raceWinners);
    }

    private RaceParticipants setRaceParticipants() {
        String carNamesInput = inputView.readCarNames();
        return new RaceParticipants(carNamesInput, new RandomNumberGenerator());
    }

    private RaceAttempts setRaceAttempts() {
        int raceAttemptsInput = inputView.readRaceAttempts();
        return new RaceAttempts(raceAttemptsInput);
    }

    private RaceWinners runRaceAndGetWinners(RaceParticipants raceParticipants, RaceAttempts raceAttempts) {
        outputView.printResultMessage();

        int attempts = raceAttempts.getAttempts();
        List<RacingCar> racingCarList = raceParticipants.getRacingCarList();

        raceInProgress(attempts, racingCarList);

        return RaceWinners.from(raceParticipants);
    }


    private void raceInProgress(int attempts, List<RacingCar> racingCarList) {
        IntStream.range(0, attempts)
                .forEach(attempt -> {
                    racingCarList.forEach(RacingCar::moveOrStop);
                    outputView.printRaceProgress(racingCarList);
                });
    }

    private void displayRaceWinners(RaceWinners raceWinners) {
        outputView.printRaceWinners(raceWinners.getWinners());
    }
}
