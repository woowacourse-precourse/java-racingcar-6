package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
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
        List<String> carNames = inputCarNames();
        int tryNumber = inputView.askTryNumber();
        Game game = new Game(tryNumber, carNames);

        List<Car> carList = new ArrayList<>();
        while (game.isPlay()) {
            carList = game.getCarList();
            moveCars(carList);

            game.updateTryNumber();
            System.out.println();
        }

        List<Car> sortedCars = getSortedCars(carList);
        List<Car> farthestCars = getFarthestCars(sortedCars);
        List<String> winnerCarNames = getWinnerCarNames(farthestCars);

        outputView.informFinalWinner(winnerCarNames);
    }

    private void moveCars(List<Car> carList) {
        carList.forEach(car -> {
            int randomDistance = Randoms.pickNumberInRange(0,9);
                    if(randomDistance >= 4) {
                car.updateCarLocation(randomDistance);
            }
            outputView.outputCarMoveDistance(car.getCarName(), randomDistance);
        });
    }

    private List<String> getWinnerCarNames(List<Car> farthestCars) {
        return farthestCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private List<Car> getFarthestCars(List<Car> sortedCars) {
        return sortedCars.stream()
                .filter(car -> car.getCarLocation() == sortedCars.get(0).getCarLocation()).toList();
    }

    private List<Car> getSortedCars(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getCarLocation).reversed()).toList();
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
