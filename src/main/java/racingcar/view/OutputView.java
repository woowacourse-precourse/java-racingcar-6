package racingcar.view;

import racingcar.model.Car;
import java.util.ArrayList;

public class OutputView {
    public static void printRace(ArrayList<Car> carList){
        carList.forEach(car -> {
                    System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
                });
    }
}
