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
        List<RacingCar> racingCar = racingCarNameConvertStringToArray(requestRacingCarNameInput());
        RacingCarGame racingCarGame = new RacingCarGame(requestnumberAttemptsCovertStringToInteger(), racingCar);
        startRacingCarGame(racingCarGame);
    }

    private void startRacingCarGame(RacingCarGame racingCarGame){
        executeResult();
        executeRacingCarRound(racingCarGame);
        winningRacingCar(racingCarGame);
    }
    private void executeRacingCarRound(RacingCarGame racingCarGame) {
        do {
            racingCarGame.repeatMovingRacingCar();
            printRacingCarRound(racingCarGame);
        }
        while (racingCarGame.isGameState());
    }

    private void printRacingCarRound(RacingCarGame racingCarGame){
        racingCarGame.getRacingCarList().forEach(v -> OutputView.printMoveRacingCar(v.getName(), v.getMove()));
        System.out.println();
    }

    private void executeResult(){
        OutputView.printResultMessage();
    }

    private void winningRacingCar(RacingCarGame racingCarGame){
        OutputView.printWinner(racingCarGame.whoIsWinner());
    }

    private List<RacingCar> racingCarNameConvertStringToArray(String racingCar) {
        List<RacingCar> racingCarList = Arrays.stream(racingCar.split(COMMA)).map(car -> new RacingCar(car, 0)).collect(Collectors.toList());
        return racingCarList;
    }

    private String requestRacingCarNameInput() {
        String racingCars = InputView.racingCarNameInput();
        RacingCarValidator.racingCarNameInputValidator(racingCars);
        return racingCars;
    }

    private Integer requestnumberAttemptsCovertStringToInteger() {
        String number = InputView.attemptNumberInput();
        RacingCarValidator.numberAttemptsInputValidator(number);
        return Integer.parseInt(number);
    }

}
