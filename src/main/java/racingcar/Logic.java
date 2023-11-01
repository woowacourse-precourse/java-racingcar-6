package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.stream.Collectors.toList;

public class Logic {
    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void doGame() {
        Output.printGuideCarName(); //4번 기능

        String input = readLine(); //1번 기능
        List<String> carNames = Input.getCarNames(input); //1번 기능

        Output.printGuideTryCount(); //5번 기능

        input = readLine();
        Long tryCount = Input.getTryCount(input); //2번 기능

        Output.printResultMessage();

        List<Car> cars = createCars(carNames);
        for(Long i = 0L; i < tryCount; i++) {
            moveCars(cars); //3번 기능
            Output.printResult(cars); //6번 기능
        }

        List<Car> carsWithMaxPosition = new ArrayList<>();
        Long maxPosition = Long.MIN_VALUE;
        for(Car car : cars) {
            int compareResult = isMaxPosition(car, maxPosition);
            maxPosition = setCarsWithMaxPosition(carsWithMaxPosition, compareResult, car, maxPosition);
        }
        Output.printWinner(carsWithMaxPosition); //7번 기능
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    private static void moveCars(List<Car> cars) {
        for(Car car : cars) {
            car.move(Randoms.pickNumberInRange(0,9));
        }
    }

    private static int isMaxPosition(Car car, Long maxPosition) {
        if (car.getPosition() > maxPosition) {
            return 1;
        }
        if (car.getPosition() == maxPosition) {
            return 0;
        }
        return -1;
    }

    private static Long setCarsWithMaxPosition(List<Car> carsWithMaxPosition, int compareResult, Car car, Long maxPosition) {
        if (compareResult == 1) {
            carsWithMaxPosition.clear();
            carsWithMaxPosition.add(car);
            return car.getPosition();
        }
        if (compareResult == 0) {
            carsWithMaxPosition.add(car);
        }
        return maxPosition;
    }
}
