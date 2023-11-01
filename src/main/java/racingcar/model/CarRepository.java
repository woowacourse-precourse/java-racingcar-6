package racingcar.model;

public class CarRepository {

    private CarCollection cars;

    public void saveAll(CarCollection cars) {
        this.cars = cars;
    }

    public CarCollection findAll() { return cars; }

}

