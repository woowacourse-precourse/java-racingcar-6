package racingcar.model;

import java.util.List;

public class CarGroup {

    private List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void move(int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
