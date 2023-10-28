package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.utils.Validator;
import racingcar.view.RaceViewer;

import java.util.Arrays;
import java.util.List;

public class CarRaceGame {
    private final CarRace carRace = new CarRace();
    private final RaceViewer viewer = new RaceViewer();

    private final static Validator validator = new Validator();

    private Cars cars;
    private int steps;

    public CarRaceGame() {}

    public void start() {
        inputCarsName();
        inputRepeatNumber();

        showRaceSteps(cars, steps);

        List<String> result = carRace.getRaceWinner(cars);
        viewer.showRaceWinner(result);
    }


    private void inputCarsName() {
        viewer.showCarsNameInput();;

        String carsNameInput = Console.readLine();
        List<String> carsName = Arrays.stream(carsNameInput.split(","))
                .toList();
        validator.checkDuplicateName(carsName);

        this.cars = new Cars(carsName);
    }

    private void inputRepeatNumber() {
        viewer.showRepeatNumberInput();
        String repeatNumber = Console.readLine();
        validator.checkRepeatNumber(repeatNumber);

        this.steps = Integer.parseI nt(repeatNumber);
    }

    private void showRaceSteps(Cars cars, int repeat) {
        viewer.showResultString();
        for (int i=0;i<repeat;i++) {
            carRace.forwardOneTurn(cars);
            viewer.showCarsStep(cars);
        }
    }
}
