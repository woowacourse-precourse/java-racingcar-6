package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String DUPLICATE_NAME = "자동차의 이름은 중복될 수 없습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            Movement movement = getRandomMovement();
            car.move(movement);
        }
    }

    public List<CarDto> getCarDtos() {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = new CarDto();
            carDto.setName(car.getName().getValue());
            carDto.setPosition(car.getPosition().getValue());

            carDtos.add(carDto);
        }
        return carDtos;
    }

    private Movement getRandomMovement() {
        int randomNumber = Util.getRandomNumber();
        return Movement.from(randomNumber);
    }

    private void validateDuplicateCarName(List<Car> cars) {
        long uniqueCarCount = countUniqueCarName(cars);
        int originalCarCount = cars.size();

        if (uniqueCarCount != originalCarCount) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private long countUniqueCarName(List<Car> cars) {
        return cars.stream()
                .map(Car::toString)
                .distinct()
                .count();
    }
}