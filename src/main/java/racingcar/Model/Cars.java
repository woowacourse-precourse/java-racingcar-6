package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import racingcar.Util.RandomGenerator;

public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;

        for (Car car : cars) {
            int position = car.getPosition();
            if (position == maxPosition) {
                winners.add(car.getCarName());
            }
            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
