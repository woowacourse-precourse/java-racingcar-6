package domain;

import dto.RoundResultDto;
import dto.WinnerDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import util.generator.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(){
        for(Car car: cars){
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
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
