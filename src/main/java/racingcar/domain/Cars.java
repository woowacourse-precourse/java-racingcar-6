package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarsGenerateDto;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Rule;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(Rule rule, RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(rule, randomNumber);
        }
    }

    public static Cars generateCars(CarsGenerateDto carsGenerateDto) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carsGenerateDto.carsName()) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    public List<Car> getCarsList() {
        return new ArrayList<>(cars);
    }
}
