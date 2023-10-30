package racingcar;

import java.util.ArrayList;

public class GameManager {
    final CarManager carManager = new CarManager();
    String[] carArray = carManager.inputForCarName();
    ArrayList<Car> cars = new ArrayList<>();
    public void carConstructor() {
        for (String name : carArray) {
            cars.add(new Car(name.trim()));
        }
    }
}
