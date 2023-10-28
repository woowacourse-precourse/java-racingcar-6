package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Judge;
import racingcar.model.Round;
import racingcar.view.SystemView;

public class GameController {

    private List<Car> cars;
    private int roundNumber;

    public GameController() {
        set();
        game();
        judge();
    }

    public void set() {

        SystemView.promptForCarNames();
        List<String> carNames = InputController.setCars();

        SystemView.promptForRoundNumber();
        roundNumber = InputController.setRound();

        // Car 객체 생성 및 자동차 이름 할당
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void game() {

        SystemView.displayGameResults();

        Round round = new Round(cars);
        round.playRound(roundNumber);
    }

    public void judge() {

        Judge.determineWinners(cars);
    }

}

