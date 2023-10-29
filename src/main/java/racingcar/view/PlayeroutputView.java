package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class PlayeroutputView {
    public static void round(List<Car> cars){
        for(Car car : cars){
            String carName = car.getName();
            String onestepMessage = "-";
            System.out.println(carName + ":" + onestepMessage.repeat(car.getPosition()));
        }
        System.out.println(" ");
    }

}
