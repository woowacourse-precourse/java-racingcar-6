package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final CarRepository carRepository;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_DISTANCE = -1;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveAllCars(List<Car> cars) {
        carRepository.saveAll(cars);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void moveCars() {
        List<Car> cars = getAllCars();

        for (Car car : cars) {
            if (FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward();
            }
        }
    }

    public int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public List<String> getCarNameHasLongestDistance() {
        List<Car> cars = getAllCars();
        List<String> winnerName = new ArrayList<>();
        int longestDistance = MIN_DISTANCE;

        for (Car car : cars) {
            int currentLocation = car.getCurrentLocation();
            if (currentLocation > longestDistance) {
                longestDistance = currentLocation;
                winnerName.clear();
                winnerName.add(car.getName());
            } else if (currentLocation == longestDistance) {
                winnerName.add(car.getName());
            }
        }
        return winnerName;
    }

}
