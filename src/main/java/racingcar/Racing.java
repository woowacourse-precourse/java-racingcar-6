package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private List<Car> cars;
    public void getCarName() {
        List<String> carName = List.of(readLine().split(","));
        carName.forEach(name -> cars.add(new Car(name, 0)));
    }

    public void printResult() {
        cars.forEach(Car::print);
    }
}
