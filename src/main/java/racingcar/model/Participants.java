package racingcar.model;

import java.util.List;
import racingcar.model.car.Car;

public class Participants {
    private final List<Car> list;

    public Participants(List list){
        this.list = list;
    }

    public void save(Car car) {
        list.add(car);
    }

    public int size() {
        return list.size();
    }
}
