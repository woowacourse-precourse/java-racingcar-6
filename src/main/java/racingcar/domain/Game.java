package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Cars.Car;

public class Game {
    private final Cars cars;

    private static final int MIN_RUNNABLE_VALUE = 4;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void play(int attempsNumber) {
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < attempsNumber; i++) {
            for (int carIdx = 0; carIdx < carList.size(); carIdx++) {
                runCar(carList.get(carIdx));
            }
            printOneRoundResult(carList);
            System.out.println();
        }
    }

    private void runCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (isRunnable(randomNumber)) {
            car.setDrawingMovement(car.getDrawingMovement() + "-");
            car.setNumberOfMoves(car.getNumberOfMoves() + 1);
        }
    }

    private boolean isRunnable(int randomNumber) {
        if (randomNumber >= MIN_RUNNABLE_VALUE) {
            return true;
        }
        return false;
    }

    private void printOneRoundResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(
                    carList.get(i).getName() + " : " + carList.get(i).getDrawingMovement());
        }
    }
}
