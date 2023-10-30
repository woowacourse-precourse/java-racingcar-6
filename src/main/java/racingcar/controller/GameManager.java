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
    public void playGame() {
        CarStorage.init();

        // 사용자 입력 받기
        userView.printInputNameMessage();
        user.inputCarNames();
        userView.printInputCountMessage();
        tryCount = user.inputTryCount();

        // 실행 결과 출력
        System.out.println();
        userView.printResultMessage();
        for (int i=0; i<tryCount; i++) {
            for (Car tempCar: CarStorage.cars()) {
                Integer randInt = user.pickRandomInt();
                tempCar.addStep(randInt);
            }
            userView.printCurrentResult();
        }
        choiceWinner();
        userView.printWinners();
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
