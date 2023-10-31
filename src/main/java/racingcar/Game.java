package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> cars = new ArrayList<>();

    public void save(String[] carNames){
        for (String name : carNames){
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
