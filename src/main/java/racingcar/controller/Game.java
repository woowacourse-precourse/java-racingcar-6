package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class Game {
    private final InputController inputController;
    public Game(){
        this.inputController = new InputController();
    }

    public void initGame(){
        OutputView.askCarNameMessage();
        Cars cars = inputController.getCarNameFromUserInput();
        for (Car car: cars.getCarList())
            System.out.println(car.getName());
    }
}
