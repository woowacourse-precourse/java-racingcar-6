package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Judge;
import racingcar.model.Round;

public class GameController {

    private List<Car> cars;
    private int roundNumber;

    public GameController() {
        set();
        game();
        judge();
    }

    public void set() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = InputController.setCars();

        System.out.println("시도할 회수는 몇회인가요?");
        roundNumber = InputController.setRound();

        // Car 객체 생성 및 자동차 이름 할당
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void game() {

        System.out.println("실행 결과");

        Round round = new Round(cars);
        round.playRound(roundNumber);
    }

    public void judge() {

        Judge.determineWinners(cars);
    }

}

