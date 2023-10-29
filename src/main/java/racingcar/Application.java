package racingcar;
import racingcar.domain.Car;
import racingcar.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<String> carsList = new ArrayList<>();;
    static List<Car> cars = new ArrayList<>();;

    public static void main(String[] args) {
        User user = new User();
        carsList = user.getCars();
        createCars(carsList);
    }
    public static void createCars(List<String> carsList) {
        for(int i=0; i<carsList.size(); i++) {
            Car car = new Car();
            car.carName = carsList.get(i);
            cars.add(car);
        }
    }
}
