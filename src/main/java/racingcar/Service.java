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
}
