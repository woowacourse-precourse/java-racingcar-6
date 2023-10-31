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

    public void move(int tryCountValue) {
        for (Car car : cars) {
            car.drive();
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        String winner = getWinner(tryCountValue);
        System.out.println("최종 우승자 : " + winner);
    }

    private String getWinner(int tryCountValue) {
        for (Car car : cars) {
            if (car.isMax == tryCountValue) {
                return car.getName();
            }
        }
        return null;
    }
}
