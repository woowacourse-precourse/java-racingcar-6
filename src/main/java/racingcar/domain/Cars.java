package racingcar.domain;

import racingcar.service.MoveForward;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        Validate.validator(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            if(stopAndGo()) {
                car.move();
            }
        }
    }

    public boolean stopAndGo() {
        int number = MoveForward.randomMoveForwards();
        return number >= 4;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String winnerJudge() {
        StringBuilder sb = new StringBuilder();
        int maxPosition = 0;
        for(Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for(Car car : cars) {
            if(car.getPosition() == maxPosition) {
                sb.append(car.getName()).append(", ");
            }
        }

        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
