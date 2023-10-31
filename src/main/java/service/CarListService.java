package service;

import repository.CarListRepository;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarListService {
    private CarListRepository carListRepository;

    public void init(String carList) {
        this.carListRepository = new CarListRepository(setCarListRepository(carList));
    }

    private static Map<String, Integer> setCarListRepository(String carList) {
        return Stream.of(carList.split(","))
                .collect(Collectors.toMap(car -> car, car -> 0));
    }

    public void forwardCar(String carName) {
        carListRepository.forwardCar(carName);
    }
}