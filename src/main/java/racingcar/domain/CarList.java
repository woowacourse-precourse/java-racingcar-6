package racingcar.domain;

import static racingcar.domain.constant.CarConstant.CAR_INIT_POSITION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utill.NumberGenerator;

public class CarList {
    private final List<Car> carList;
    private final NumberGenerator numberGenerator;

    public CarList(List<Car> carList, NumberGenerator numberGenerator) {
        this.carList = new ArrayList<>(carList);
        this.numberGenerator = numberGenerator;
    }

    public List<CarRacingResponse> decisionCarsMoveOrStop1() {
        List<CarRacingResponse> carsResponses = new ArrayList<>();
        for (Car car : carList) {
            int carPosition = car.decisionMoveOrStop(numberGenerator.generateNumber());
            String carName = car.getCarName();
            carsResponses.add(CarRacingResponse.create(carName, carPosition));
        }

        return carsResponses;
    }

    public String decisionRacingWinner() {
        return String.join(", ", findWinner());
    }

    private List<String> findWinner() {
        return carList.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getCarPosition)
                .max().orElse(CAR_INIT_POSITION);
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
