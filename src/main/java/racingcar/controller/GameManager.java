package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.GameUI;
import racingcar.view.RaceView;

public class GameManager {
    private int remainingRounds;
    private List<Car> cars;

    public GameManager() {
    }

    public void runGame() {
        // 게임 전체적인 진행관리
    }

    private void setupGame() {
        List<String> carsName = GameUI.promptForCarNamesAndReturnList();
        for (String name : carsName) {
            this.cars.add(new Car(name));
        }
        this.remainingRounds = GameUI.promptForNumberOfRoundsAndReturnInteger();
    }

    private void playGame() {
        for (; remainingRounds > 0; remainingRounds--) {
            cars.forEach(Car::moveOnRandomCondition);
            RaceView.displayRoundResults(cars);
        }
    }

    private void endGame() {
        // 게임이 끝난후 우승자 선정 및, 보여주기
    }

    private void determinWinner() {
        // 자동차 객체 리스트중 가장 많이 간 우승자를 선발한다
    }
}
