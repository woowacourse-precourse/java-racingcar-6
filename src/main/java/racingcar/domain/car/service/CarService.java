package racingcar.domain.car.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.car.view.CarOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCars(List<String> carNames) {
        saveCar(createCars(carNames));
    }

    private void saveCar(List<Car> cars) {
        cars.forEach(carRepository::save);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<String> getWinner() {
        List<Car> carWithMaxPosition = carRepository.findCarWithMaxPosition();
        return carWithMaxPosition.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Car> startRacingCar() {
        return carRepository.findAll()
                .stream()
                .map(car -> car.race(getRandomNumber()))
                .toList();
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
