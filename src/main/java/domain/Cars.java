package domain;

import dto.RoundResultDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<RoundResultDto> getCarsInformation() {
        List<RoundResultDto> carInfos = new ArrayList<>();
        for (Car car : cars) {
            String name = car.getCarName().getValue();
            int location = car.getCarLocation().getValue();
            carInfos.add(new RoundResultDto(name, location));
        }
        return carInfos;
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }


}
