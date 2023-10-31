package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.NamesRequestDto;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.repository.CarRepository;
import racingcar.util.GameUtil;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void addCars(NamesRequestDto cars) {
        List<Car> carList = new ArrayList<>();
        for (String name : cars.names()) {
            carList.add(Car.CreateCar(name));
        }
        carRepository.saveAll(carList);
    }

    public CarsResponseDto raceCar() {
        List<Car> findCars = carRepository.findAll();
        for (Car car : findCars) {
            car.move(GameUtil.move());
        }
        List<Car> updateCars = carRepository.updateAll(findCars);
        return CarsResponseDto.createCarsResponseDto(updateCars);
    }

    public WinnerResponseDto getWinners() {
        int maxProgress = carRepository.countByProgressDescLimitOne();
        List<Car> findCars = carRepository.findAllByProgress(maxProgress);
        return WinnerResponseDto.createWinnerResponseDto(findCars);
    }


}
