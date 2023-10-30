package Domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + car.getPosition());
        }
    }

    public String getWinners() {

        return "최종 우승자 : ";
    }
}
