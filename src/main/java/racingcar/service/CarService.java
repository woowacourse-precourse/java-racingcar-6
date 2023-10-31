package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.namesRequestDto;
import racingcar.dto.ProgressResponseDto;
import racingcar.dto.WinnersResponseDto;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void addCars(namesRequestDto cars) {
        List<Car> carList = new ArrayList<>();
        for (String name : cars.getNamesList()) {
            carList.add(Car.CreateCar(name));
        }
        carRepository.saveAll(carList);
    }

    public ProgressResponseDto raceCar() {
        return null;
    }

    public WinnersResponseDto getWinners() {
        return null;
    }


}
