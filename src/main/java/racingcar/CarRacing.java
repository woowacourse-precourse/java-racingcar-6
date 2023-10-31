package racingcar;

import static racingcar.RacingConst.RESULT;

import java.util.HashMap;
import java.util.List;

public class CarRacing {
    HashMap<String, Integer> cars;
    Referee referee;

    public CarRacing() {
        this.cars = new HashMap<>();
        this.referee = new Referee();
    }

    public void start() {
        participateCars();
        race();
        whichWinners();
    }

    public void race() {
        int maxTurn = Prompt.readMaxTurn();
        System.out.println(RESULT);
        for (int turn = 0; turn < maxTurn; turn++) {
            action();
        }
    }

    public void action() {
        cars.forEach((car, position) -> {
            Integer randomNumber = NumberGenerator.createRandomNumber();
            if (CarUtils.isMovable(randomNumber)) {
                CarUtils.move(cars, car);
            }
        });
        Prompt.printCarPositions(cars);
    }

    public void participateCars() {
        String[] carNames = Prompt.readCarNames();
        for (String carName : carNames) {
            cars.put(carName, 0);
        }
    }

    public void whichWinners() {
        List<String> winners = referee.choiceWinners(cars);
        Prompt.printWinners(winners);
    }
}
