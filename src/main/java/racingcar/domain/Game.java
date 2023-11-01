package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Cars.Car;

public class Game {
    private final Cars cars;

    private static final int MIN_RUNNABLE_VALUE = 4;
    private final static int RANDOM_NUMBER_LOWER_BOUND = 0;
    private final static int RANDOM_NUMBER_HIGHER_BOUND = 9;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void play(int attempsNumber) {
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < attempsNumber; i++) {
            for (int carIdx = 0; carIdx < carList.size(); carIdx++) {
                int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_HIGHER_BOUND);

                processCarMovement(carList.get(carIdx), randomNumber);
            }
            printOneRoundResult(carList);
            System.out.println();
        }
    }

    public void processCarMovement(Car car, int randomNumber) {
        if (isRunnable(randomNumber)) {
            car.setDrawingMovement(car.getDrawingMovement() + "-");
            car.setNumberOfMoves(car.getNumberOfMoves() + 1);
        }
    }

    public boolean isRunnable(int randomNumber) {
        if (randomNumber >= MIN_RUNNABLE_VALUE) {
            return true;
        }
        return false;
    }

    public void printOneRoundResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(
                    carList.get(i).getName() + " : " + carList.get(i).getDrawingMovement());
        }
    }
}
