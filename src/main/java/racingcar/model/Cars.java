package racingcar.model;


import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getCarsLength(){
        return cars.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            sb.append("-".repeat(Math.max(0, car.getPosition())));
            sb.append("\n");
        }
        return sb.toString();
    }
}
