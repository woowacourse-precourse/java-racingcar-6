package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarsGenerateDto;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Rule;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(Rule rule) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(rule, randomNumber);
        }
    }

    public static Cars generate(CarsGenerateDto carsGenerateDto) {
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
