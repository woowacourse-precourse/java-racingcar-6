package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        String carNames = inputView.askCarNames();
        List<String> carName = splitCarNames(carNames);

        List<Car> cars = new ArrayList<>();

        for (String name : carName) {
            Car car = new Car(name);
            cars.add(car);
        }

        int tryNumber = inputView.askTryNumber();

        int count = 0;
        while (count < tryNumber) {
            for (Car car : cars) {
                int randomDistance = Randoms.pickNumberInRange(0, 9);
                if(randomDistance >= 4) {
                    car.updateCarLocation(randomDistance);
                }
                outputView.outputCarMoveDistance(car.getCarName(), randomDistance);
            }

            count += 1;
        }
    }

    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}
