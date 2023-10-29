package racingcar.repository;

import java.util.ArrayList;
import racingcar.Domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class CarRepository {
    private final static CarRepository instance = new CarRepository();

    private ArrayList<Car> garage = new ArrayList<>();


    private CarRepository() {

    }

    public static CarRepository getInstance() {
        return instance;
    }

    public void save(CarsDto carsDto) {
        ArrayList<CarDto> carArrayList = carsDto.getCarArrayList();

        carArrayList.stream()
                .forEach(carDto -> {
                    garage.add(new Car(carDto.getCarName()));
                });
    }

    public ArrayList<Car> findAll() {
        return garage;
    }
}
