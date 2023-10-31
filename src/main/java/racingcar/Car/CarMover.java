package racingcar.Car;

import racingcar.Computer.RandomNumber;
import java.util.List;
import racingcar.Constants.CarConstants;


public class CarMover {

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomNumber.generate();
            int distance = determineMoveDistance(randomNumber);
            car.move(distance);
        }
    }

    public static int determineMoveDistance(int randomNumber) {
        if (randomNumber < CarConstants.MOVE_THRESHOLD) {
            return CarConstants.STOP_DISTANCE;
        }
        return CarConstants.MOVE_DISTANCE;
    }
}