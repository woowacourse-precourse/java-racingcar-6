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

    public void saveAllCars(CarCollection cars) {
        carRepository.saveAll(cars);
    }

    public CarCollection getAllCars() {
        return carRepository.findAll();
    }

    public void moveCars() {
        CarCollection cars = getAllCars();

        for (Car car : cars.getCars()) {
            moveIfSatisfyCondition(car);
        }
    }

    public void moveIfSatisfyCondition(Car car) {
        if (FORWARD_CONDITION <= getRandomNumber()) {
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public List<String> getCarNameHasLongestDistance() {
        CarCollection cars = getAllCars();
        List<String> winnerName = new ArrayList<>();
        int longestDistance = MIN_DISTANCE;

        for (Car car : cars.getCars()) {
            int currentLocation = car.getCurrentLocation();
            longestDistance = getLongestDistance(winnerName, longestDistance, car, currentLocation);
        }
        return winnerName;
    }

    public int getLongestDistance(List<String> winnerName, int longestDistance, Car car, int currentLocation) {
        if (currentLocation > longestDistance) {
            longestDistance = currentLocation;
            winnerName.clear();
            winnerName.add(car.getName());
        } else if (currentLocation == longestDistance) {
            winnerName.add(car.getName());
        }
        return longestDistance;
    }

}
