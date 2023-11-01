package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class RacingCarController {

    private RacingCarController() {
    }

    public static void start() {
        List<String> names;
        List<Car> cars;
        int count;

        names = InputController.nameInputController();
        count = InputController.countInputController();

        cars = generateCars(names);
        run(cars, count);

        System.out.println(OutputView.finalWinnerView(getWinner(cars)));
    }

    public static List<Car> generateCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private static void run(List<Car> carList, int count) {
        for (int counter = 0; counter < count; counter++) {
            for (Car car : carList) {
                moveOrStop(car);
            }

            System.out.println(OutputView.progressView(carList));
        }
    }

    private static void moveOrStop(Car car) {
        if (Randoms.pickNumberInRange(0, 9) <= 4) {
            car.moveForward();
        }
    }

    private static List<Car> getWinner(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : carList) {
            int carDistance = car.getForwardDistance();

            if (carDistance > maxDistance) {
                maxDistance = carDistance;
            }
        }

        for (Car car : carList) {
            if (car.getForwardDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}
