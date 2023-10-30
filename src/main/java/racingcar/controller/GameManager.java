package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarStorage;
import racingcar.view.UserView;

public class GameManager {
    // 타 클래스 변수
    private UserView userView;
    private User user;
    // GameManager 변수
    private Integer tryCount;
    public GameManager() {
        userView = new UserView();
        user = new User();
    }


    private void choiceWinner() {
        Integer tempCarStep;
        Integer maxStep = CarStorage.getMaxSteps();
        for (Car tempCar : CarStorage.cars()) {
            tempCarStep = tempCar.steps();
            if (tempCarStep.equals(maxStep)) {
                CarStorage.addWinner(tempCar);
            }
        }
    }
}
