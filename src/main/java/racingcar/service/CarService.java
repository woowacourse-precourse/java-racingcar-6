package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.namesRequestDto;
import racingcar.dto.ProgressResponseDto;
import racingcar.dto.WinnerResponseDto;
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

    public WinnerResponseDto getWinners() {
        int maxProgress = carRepository.countByProgressDescLimitOne();
        List<Car> findCars = carRepository.findAllByProgress(maxProgress);
        return WinnerResponseDto.createWinnerResponseDto(findCars);
    }


}
