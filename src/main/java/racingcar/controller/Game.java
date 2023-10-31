package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class Game {
    private final InputController inputController;
    private final int START_INCLUSIVE = 0;
    private final int END_INCLUSIVE = 9;
    private static final int FORWARD_CONDITION = 4;
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

        match(cars, attemptCount);
    }

    public void match(Cars cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveForwardByRandomNumber(cars);
        }
    }

    public void moveForwardByRandomNumber(Cars cars) {
        for (Car car : cars.getCarList()) {
            if (getRandomNumber() >= FORWARD_CONDITION)
                car.moveForward();
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
