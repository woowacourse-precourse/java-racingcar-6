package racingcar;

public class Racing {
    private final Cars cars;

    public static Racing createRacing(String[] names) {
        Cars cars = Cars.createCars(names);
        return new Racing(cars);
    }

    private Racing(Cars cars) {
        this.cars = cars;
    }

    public void playRacing() {
        cars.moveCars();
    }
}
