package racingcar.Car;

import racingcar.Computer.RandomNumber;
import java.util.List;
import racingcar.Constants.CarMoverConstants;


public class CarMover {

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int distance = RandomNumber.generate();
            if(distance < CarMoverConstants.MOVE_THRESHOLD ){
                distance = CarMoverConstants.STOP_DISTANCE ;
            }
            if(distance >= CarMoverConstants.MOVE_THRESHOLD ){
                distance = CarMoverConstants.MOVE_DISTANCE;
            }
            car.move(distance);
        }

    }
}