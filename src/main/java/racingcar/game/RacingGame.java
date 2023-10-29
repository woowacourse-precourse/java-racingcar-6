package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.message.Console;
import racingcar.evaluator.Evaluator;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGame {

    private static final String FOOTPRINT = "-";
    private static final int MIN_MOVE_VALUE = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    static Evaluator evaluator = new Evaluator();

    public static void run() {
        Console.requestCarName();
        List<Car> cars = inputCarName();

        Console.requestCount();
        int gameCount = inputGameCount();

        while (gameCount > 0) {
            for (Car car : cars) {
                moveCar(car);
                Console.move(car.getName(), convertMovementToString(car));
            }
            System.out.println();
            gameCount--;
        }
        evaluator.evaluate(cars);
    }

    static List<Car> inputCarName() {
        String inputCars = readLine();
        return saveCars(inputCars);
    }

    static List<Car> saveCars(String inputCars) {
        String[] carNames = inputCars.split(",");
        List<Car> cars = new ArrayList<>();

        for (String car : carNames) {
            cars.add(new Car(car));
        }
        return cars;
    }

    static int inputGameCount() {
        return Integer.parseInt(readLine());
    }

    static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    static void moveCar(Car car) {
        if (generateRandomNumber() >= MIN_MOVE_VALUE) {
            car.updateMovingCount();
        }
    }

    static String convertMovementToString(Car car) {
        return FOOTPRINT.repeat(car.getMoving());
    }
}
