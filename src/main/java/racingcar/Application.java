package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = initCars();
        int moveTryCount = initMoveTryCount();
        System.out.println("실행 결과");
        int carCount = cars.carCount();
        IntStream.range(0, moveTryCount)
                .forEach(value -> {
                    tryMoveCars(cars, carCount);
                    printCarsStatus(cars);
                });
        OutputManager.printWinner(cars);
    }

    private static Cars initCars() {
        OutputManager.printCarsNameInputGuide();
        List<String> carNames = InputManager.getCarNames();
        Cars cars = new Cars(carNames);
        return cars;
    }

    private static int initMoveTryCount() {
        OutputManager.printMoveTryCountInputGuide();
        int moveTryCount = InputManager.getMoveTryCount();
        return moveTryCount;
    }

    private static void printCarsStatus(Cars cars) {
        OutputManager.printCarsMoveStatus(cars);
    }

    private static void tryMoveCars(Cars cars, int carCount) {
        List<Integer> movePowers = RandomIntgerListGenerator.generate(0, 9, carCount);
        cars.tryMoveAll(movePowers);
    }
}
