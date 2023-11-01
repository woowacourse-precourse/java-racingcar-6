package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManagement {
    private final List<CarInformation> cars;

    public GameManagement(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new CarInformation(name));
        }
    }
    public void playRound(){
        for (CarInformation car : cars) {
            car.move();
        }
    }

    public List<CarInformation> getWinners(){
        return null;
    }

}
