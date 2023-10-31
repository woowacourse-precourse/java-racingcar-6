package racingcar.domain;

import static racingcar.domain.constant.CarConstant.CAR_INIT_POSITION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarRacingResponse;
import racingcar.utill.NumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<Car> carList, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>(carList);
        this.numberGenerator = numberGenerator;
    }

    public List<CarRacingResponse> decisionCarsMove() {
        List<CarRacingResponse> carsResponses = new ArrayList<>();
        for (Car car : cars) {
            int carPosition = car.move(numberGenerator.generateNumber());
            String carName = car.getCarName();
            carsResponses.add(CarRacingResponse.create(carName, carPosition));
        }

        return carsResponses;
    }

    public String decisionWinner() {
        return String.join(", ", findWinner());
    }

    private List<String> findWinner() {
        return cars.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max().orElse(CAR_INIT_POSITION);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
