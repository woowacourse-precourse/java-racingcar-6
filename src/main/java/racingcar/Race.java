package racingcar;

import java.util.List;
import model.Car;

public class Race {

    public String raceCar(List<Car> cars, int times){
        while(times > 0){
            System.out.print("\n");

            for (Car car : cars) {
                int move = car.moveForward();
                System.out.println(car.getName() + " : " + move + car.getPosition());
            }
            times--;

        }
        return "게임종료";
    }
}
