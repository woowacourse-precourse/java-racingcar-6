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
        //자동차 이름 입력 확인
        for (Car car: cars.getCarList())
            System.out.println(car.getName());

        OutputView.askAttemptCount();;
        int attemptCount = inputController.getAttemptCountFromUserInput();
        //입력 횟수 확인
        System.out.println(attemptCount);
    }
}
