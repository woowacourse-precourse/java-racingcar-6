package racingcar;

import java.util.ArrayList;

public class CarRepository {
    private final static CarRepository instance = new CarRepository();

    private ArrayList<Car> garage = new ArrayList<>();


    private CarRepository(){

    }

    public static CarRepository getInstance(){
        return instance;
    }

    public void save(CarsDto carsDto) {
        ArrayList<CarDto> carArrayList = carsDto.getCarArrayList();

        carArrayList.stream()
                .forEach(carDto -> {
                    garage.add(new Car(carDto.getCarName()));
                });
    }
}
