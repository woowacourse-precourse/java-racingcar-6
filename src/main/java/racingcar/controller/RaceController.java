package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.UserInput;
import racingcar.view.OutputView;

public class RaceController {
    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;
    static final int LIMIT = 4;

    public static List<Car> setCars() {
        String[] carNames = UserInput.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int setTotalRound() {
        return UserInput.getTotalRound();
    }

    public static void doRound(List<Car> cars) {
        for (Car car : cars) {
            decideMovement(car);
        }
        OutputView.printRaceStatus(cars);
    }

    public static void decideMovement(Car car) {
        int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (number >= LIMIT) {
            car.moveForward();
        }
    }
}
