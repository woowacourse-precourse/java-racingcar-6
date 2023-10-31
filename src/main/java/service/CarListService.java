package service;

import repository.CarListRepository;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarListService {
    private CarListRepository carListRepository;

    public void init(String carList) {
        this.carListRepository = new CarListRepository(stringSplitAndToMap(carList));
    }

    private static LinkedHashMap<String, Integer> stringSplitAndToMap(String carList) {
        String[] carArray = carList.split(",");
        return Stream.of(carArray)
                .collect(Collectors.toMap(carName -> carName, carName -> 0, (a, b) -> b, LinkedHashMap::new));
    }

    public LinkedHashMap<String, Integer> getCarList() {
        return carListRepository.carList();
    }

    public void forwardCar(String carName) {
        carListRepository.forwardCar(carName);
    }
}