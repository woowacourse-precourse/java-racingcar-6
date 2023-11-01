package racingcar.domain;

import java.util.List;
import java.util.Vector;

public class CarRepository {
    private List<Car> cars = new Vector<>();

    public List<Car> getPlayers() {
        return cars;
    }

    //player 추가 로직
    public void addPlayer(Car car){
        cars.add(car);
    }

}
