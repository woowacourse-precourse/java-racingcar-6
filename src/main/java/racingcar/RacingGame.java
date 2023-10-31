package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars = new ArrayList<>();

    public void inputCarsName() {
        String[] carsName = Console.readLine().split(",");
        for (String s : carsName) {
            cars.add(new Car(s));
        }
    }

    public void printCarsName() {
        for (Car c : cars) {
            System.out.println(c.getName());
        }
    }


}
