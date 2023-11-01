package mapper;

import controller.dto.CarDto;
import domain.Car;
import domain.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {
    private final CarService carService;

    public CarMapper(CarService carService) {
        this.carService = carService;
    }

    public void setCars(List<String> names) {
        carService.setCars(names);
    }

    public void setRound(int round) {
        carService.setRound(round);
    }

    public void playRound() {
        carService.playRound();
    }

    public List<CarDto> getState() {
        return carsToDto(carService.getCars());
    }

    public List<CarDto> decideWinner() {
        return carsToDto(carService.decideWinner());
    }

    private List<CarDto> carsToDto(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }

    public boolean isEnd() {
        return carService.isEnd();
    }
}
