package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.message.Printer;
import racingcar.evaluator.Evaluator;

public class RacingGame {

    private static final String FOOTPRINT = "-";
    private static final int MIN_MOVE_VALUE = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    static Evaluator evaluator = new Evaluator();

    public static void run() {
        Printer.requestCarName();
        List<Car> cars = inputCarName();

        Printer.requestCount();
        int gameCount = inputGameCount();

        while (gameCount > 0) {
            for (Car car : cars) {
                moveCar(car);
                Printer.move(car.getName(), convertMovesToString(car));
            }
            System.out.println();
            gameCount--;
        }
        evaluator.evaluate(cars);
    }

    private static List<Car> inputCarName() {
        String inputCars = Console.readLine();
        return saveCars(inputCars);
    }

    private static List<Car> saveCars(String inputCars) {
        String[] carNames = inputCars.split(",");
        List<Car> cars = new ArrayList<>();

        for (String car : carNames) {
            cars.add(new Car(car));
        }
        return cars;
    }

    private static int inputGameCount() {
        return Integer.parseInt(Console.readLine());
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private static void moveCar(Car car) {
        if (generateRandomNumber() >= MIN_MOVE_VALUE) {
            car.updateMovingCount();
        }
    }

    private static String convertMovesToString(Car car) {
        return FOOTPRINT.repeat(car.getMoving());
    }
}
