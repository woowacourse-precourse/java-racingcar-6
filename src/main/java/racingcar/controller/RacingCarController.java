package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCar;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final String COMMA = ",";

    public void start() {
        initializeRacingGame();
    }

    private void initializeRacingGame() {
        List<RacingCar> racingCar = racingCarNameConvertStringToArray(racingCarNameInput());
        RacingCarGame racingCarGame = new RacingCarGame(requestAttemptNumberCovertStringToInteger(), racingCar);
        executeRacingCarRound(racingCarGame);
    }

    private void executeRacingCarRound(RacingCarGame racingCarGame) {
        OutputView.printResultMessage();
        do {
            racingCarGame.repeatMovingRacingCar();
            racingCarGame.getRacingCarList().forEach(v -> OutputView.printMoveRacingCar(v.getName(), v.getMove()));
            System.out.println();
        }
        while (racingCarGame.isGameState());
        OutputView.printWinner(racingCarGame.whoIsWinner());
    }

    public List<RacingCar> racingCarNameConvertStringToArray(String racingCar) {
        List<RacingCar> racingCarList = Arrays.stream(racingCar.split(COMMA)).map(car -> new RacingCar(car, 0)).collect(Collectors.toList());
        return racingCarList;
    }

    private String racingCarNameInput() {
        String racingCars = InputView.racingCarNameInput();
        RacingCarValidator.racingCarInputNameValidator(racingCars);
        return racingCars;
    }

    private Integer requestAttemptNumberCovertStringToInteger() {
        String number = InputView.attemptNumberInput();
        RacingCarValidator.attemptInputNumberValidator(number);
        return Integer.parseInt(number);
    }

}
