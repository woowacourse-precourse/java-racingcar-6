package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();

    public void run() {
        play();
    }

    public void play() {
        List<String> carName = inputCarNames();


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
            System.out.println();
        }

        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparingInt(Car::getCarLocation).reversed()).toList();

        List<Car> farthestCars = sortedCars.stream()
                .filter(car -> car.getCarLocation() == sortedCars.get(0).getCarLocation()).toList();

        List<String> winnerCarNames = farthestCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        outputView.informFinalWinner(winnerCarNames);
    }

    private List<String> inputCarNames() {
        String carNames = inputView.askCarNames();
        List<String> carName = splitCarNames(carNames);
        validator.validateCarNameLength(carName);
        return carName;
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}
