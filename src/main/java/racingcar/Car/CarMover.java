package racingcar.Car;

import racingcar.Computer.RandomNumber;
import java.util.List;
import racingcar.Constants.CarConstants;


public class CarMover {

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int distance = RandomNumber.generate();
            if(distance < CarConstants.MOVE_THRESHOLD ){
                distance = CarConstants.STOP_DISTANCE ;
            }
            if(distance >= CarConstants.MOVE_THRESHOLD ){
                distance = CarConstants.MOVE_DISTANCE;
            }
            car.move(distance);
        }

    }
}