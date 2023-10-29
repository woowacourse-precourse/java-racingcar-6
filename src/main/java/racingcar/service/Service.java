package racingcar.service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.repository.CarRepository;

public class Service {
    CarRepository carRepository;

    public Service() {
        this.carRepository = CarRepository.getInstance();
    }


    public void saveCars(CarsDto carsDto) {
        carRepository.save(carsDto);
    }

    public void runOnce() {
        ArrayList<Car> garage = carRepository.findAll();
        garage.stream()
                .forEach(car -> car.runTrack());
    }

    public CarsDto getResultOfOneTrack() {
        ArrayList<Car> garage = carRepository.findAll();
        ArrayList<CarDto> carDtoArrayList = new ArrayList<>();
        garage.stream()
                .forEach(car -> {
                    carDtoArrayList.add(new CarDto(car.getName(), car.getCurrentPosition()));
                });
        CarsDto carsDto = new CarsDto(carDtoArrayList);

        return carsDto;
    }

    public CarsDto getWinner() {
        ArrayList<Car> garage = carRepository.findAll();
        int winnerDistance = garage.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);

        ArrayList<Car> winners = (ArrayList<Car>) garage.stream()
                .filter(car -> car.getCurrentPosition() == winnerDistance)
                .collect(Collectors.toList());

        ArrayList<CarDto> cars = new ArrayList<>();

        winners.stream()
                .forEach(car -> {
                    cars.add(new CarDto(car.getName()));
                });

        CarsDto carsDto = new CarsDto(cars);
        return carsDto;
    }
}
