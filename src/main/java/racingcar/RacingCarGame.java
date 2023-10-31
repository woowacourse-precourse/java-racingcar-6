package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Validator;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingCarGame {
    private final List<Car> cars = new ArrayList<>();
    private Integer iterNumber = 0;

    public void gameStart() {
        RacingCarInputView racingCarInputView = new RacingCarInputView();

        String names = racingCarInputView.carNameInput();
        Validator.validateNames(names);
        createCars(names);

        String number = racingCarInputView.carNumberInput();
        Validator.validateNumber(number);
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
