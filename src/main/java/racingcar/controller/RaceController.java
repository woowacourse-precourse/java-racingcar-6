package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        OutputView.printResultTitle();
        int round = START_ROUND;
        while (round <= totalRound) {
            doRound(cars);
            round++;
        }
        List<String> winnerNames = getWinnerNames(cars);
        OutputView.printWinner(winnerNames);
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

    public static List<String> getWinnerNames(List<Car> cars) {
        int winnerLocation = findWinnerLocation(cars);
        return cars.stream()
                .filter(car -> isWinner(car, winnerLocation))
                .map(car -> car.name)
                .collect(Collectors.toList());
    }

    public static int findWinnerLocation(List<Car> cars) {
        Collections.sort(cars);
        return cars.get(0).location;
    }

    public static boolean isWinner(Car car, int winnerLocation) {
        return car.location == winnerLocation;
    }
}
