package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.CarRace;
import racingcar.model.InputValidator;
import racingcar.model.RacingCar;
import racingcar.model.RandomDistanceGenerator;
import racingcar.view.View;

public class RaceGameController {

    private final View view;
    private CarRace carRace;
    private final InputValidator inputValidator;

    public RaceGameController(View view, InputValidator inputValidator) {
        this.view = view;
        this.inputValidator = inputValidator;
    }

    public void start() {
        initializeGame();
        raceStart();
        racePrintRaceResults();
    }

    private void initializeGame() {
        List<String> carNames = getValidatedCarNames();
        int targetTurn = getValidatedTargetTurn();

        RandomDistanceGenerator randomDistanceGenerator = new RandomDistanceGenerator();
        List<RacingCar> racingCars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());

        carRace = new CarRace(racingCars, targetTurn, randomDistanceGenerator);
    }

    private List<String> getValidatedCarNames() {
        String cars = view.requestRaceCars();
        return inputValidator.splitAndValidateCarNames(cars);
    }

    private int getValidatedTargetTurn() {
        String requestRound = view.requestRaceRounds();
        return inputValidator.validateInputNumber(requestRound);
    }

    private void raceStart() {
        view.raceResult();
        raceAndPrintRoundResults();
    }

    private void raceAndPrintRoundResults() {
        Stream.iterate(0, n -> n + 1)
                .limit(carRace.getTargetTurn())
                .forEach(turn -> {
                    List<RacingCar> racingCars = carRace.race();
                    view.raceRoundResult(racingCars);
                });
    }

    private void racePrintRaceResults() {
        List<RacingCar> winners = carRace.getWinners();
        String winnersNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        view.raceWinners(winnersNames);
    }
}