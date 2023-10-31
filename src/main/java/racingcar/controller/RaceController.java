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
    static final int START_ROUND = 1;

    public static void race() {
        List<Car> cars = setCars();
        int totalRound = setTotalRound();
        int round = START_ROUND;
        while (round <= totalRound) {
            doRound(cars);
            round++;
        }
        List<Car> winnerList = getWinners(cars);
    }

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

    public static List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int winnerLocation = 0;
        for (Car car : cars) {
            winnerLocation = Math.max(winnerLocation, car.location);
        }
        for (Car car : cars) {
            if (car.location == winnerLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
