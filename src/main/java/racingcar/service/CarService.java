package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.repository.CarRepository;

import java.util.Arrays;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private void createCarList(String input, Game game) {
        List<String> names = Arrays.stream(input.split(",")).toList();
        for (String name : names) {
            Car saveCar = carRepository.save(name);
            game.addCar(saveCar);
        }
    }


}
