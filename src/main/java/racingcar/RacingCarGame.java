package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final List<Car> cars = new ArrayList<>();
    private Integer iterNumber = 0;

    public void gameStart() {
        RacingCarInputView racingCarInputView = new RacingCarInputView();

        String names = racingCarInputView.carNameInput();
        if (!Validator.validateNames(names).equals(names)) {
            return;
        }
        createCars(names);

        String number = racingCarInputView.carNumberInput();
        if (!Validator.validateNumber(number).equals(number)) {
            return;
        }
        iterNumber = Integer.parseInt(number);

        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.moveResultPrint(iterNumber, cars);

        List<String> winners = findWinner(cars);
        racingCarOutputView.winnerPrint(winners);

    }

    public void createCars(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public List<String> findWinner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
