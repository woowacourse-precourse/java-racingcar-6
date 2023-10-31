package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.OutputView;

public class Game {
    private final InputController inputController;
    private final RandomNumberGenerator randomNumberGenerator;
    public Game(){
        this.inputController = new InputController();
        this.randomNumberGenerator = new RandomNumberGenerator(0, 9);
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
