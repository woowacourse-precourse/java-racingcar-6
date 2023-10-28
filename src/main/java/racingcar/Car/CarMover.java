package racingcar.Car;

import racingcar.Computer.RandomNumber;
import java.util.List;

public class CarMover {

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int distance = RandomNumber.generate();
            if(distance<4){
                distance = 0;
            }
            if(distance>=4){
                distance = 1;
            }
            car.move(distance);
        }

    }
}