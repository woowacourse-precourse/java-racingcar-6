package racingcar.controller;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarRace;
import racingcar.utils.Validity;
import racingcar.view.RacingCarGameView;

import static racingcar.utils.Constants.COMMA;
import static racingcar.utils.Constants.ZERO;

public class RacingCarGame {
    RacingCarRace carRace;
    RacingCarGameView view;

    public RacingCarGame() {
        view = new RacingCarGameView();
    }

    public void run() {
        this.prepare();
        this.start();
        this.end();
    }

    private void prepare() {
        String[] carNames = this.getCarName();
        int totalMoveCount = this.getTotalMoveCount();

        List<RacingCar> racingCars = Arrays.stream(carNames).map(RacingCar::new).toList();

        this.carRace = new RacingCarRace(racingCars, totalMoveCount);
    }

    private void start() {
        view.printResultText();

        for(int n=ZERO; n<this.carRace.getTotalMoveCount(); n++) {
            this.carRace.move();
            view.printResult(this.carRace.getCarsStatus());
        }
    }

    private void end() {
        view.printWinner(this.carRace.getWinnerCarNames());
    }


    private String[] getCarName() {
        view.enterCarNames();
        String carNamesStr = Console.readLine();

        if(carNamesStr == null) {
            throw new IllegalArgumentException();
        }

        String[] carNames = carNamesStr.split(COMMA);
        for(String carName: carNames) {
            carNameValidCheck(carName);
        }

        return carNames;
    }

    private void carNameValidCheck(String carName) {
        if(!Validity.isLessThanFiveCharacters(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private int getTotalMoveCount() {
        view.enterTotalMoveCount();
        String totalMoveCountStr = Console.readLine();

        if(totalMoveCountStr == null) {
            throw new IllegalArgumentException();
        }

        if(!Validity.isPlusIntNumber(totalMoveCountStr)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(totalMoveCountStr);
    }
}
