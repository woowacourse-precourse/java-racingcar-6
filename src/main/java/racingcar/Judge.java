package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    
    private List<Car> cars;
    
    public Judge(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> decideWinner() {
        for (Car car : cars) {
            int position = car.getPosition();
        }
        return new ArrayList<>();
    }
}
