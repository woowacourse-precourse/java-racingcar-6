package racingcar.model;

public class CarRepository {
    private CarCollection carCollection;

    public void saveAll(CarCollection carCollection) {
        this.carCollection = carCollection;
    }

    public CarCollection findAll() { return carCollection; }
}

