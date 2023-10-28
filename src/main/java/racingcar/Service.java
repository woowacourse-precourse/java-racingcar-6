package racingcar;

import java.util.ArrayList;

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
                    carDtoArrayList.add(new CarDto(car.getName(),car.getCurrentPosition()));
                });
        CarsDto carsDto = new CarsDto(carDtoArrayList);

        return carsDto;
    }
}
