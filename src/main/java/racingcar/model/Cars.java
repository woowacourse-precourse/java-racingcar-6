package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.CarNameUtil;
import racingcar.util.ResultUtil;
import racingcar.validator.CarNamesValidator;

public class Cars {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVE_NUMBER = 4;

    private List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        CarNamesValidator.validate(names);
        generateCars(names);
    }

    private void generateCars(String names) {
        List<String> nameList = CarNameUtil.parseNamesToList(names);
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void decideToMove() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_MOVE_NUMBER) {
                car.movePosition();
            }
        });
    }

    public String generateRoundResultString() {
        return ResultUtil.roundFormat(cars);
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            if (car.isGreaterPositionThan(maxPosition)) {
                maxPosition = car.position();
            }
        }
        return maxPosition;
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

}
