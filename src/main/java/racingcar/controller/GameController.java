package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.game.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private Game game;

    public void run() {
        prepareSettingValue();
        play();
    }

    public void play() {
        while (game.isPlay()) {
            moveCars();
            game.updateTryNumber();
        }
        List<Car> carList = game.getCarList();
        sortFinalWinner(carList);
    }

    private void prepareSettingValue() {
        List<String> carNames = inputCarNames();
        int tryNumber = InputView.askTryNumber();
        game = new Game(tryNumber, carNames);
    }

    private List<String> inputCarNames() {
        String carNames = InputView.askCarNames();
        List<String> carName = splitCarNames(carNames);
        validateCarNameLength(carName);
        return carName;
    }

    private static void validateCarNameLength(List<String> carName) {
        if(carName.stream().anyMatch(name -> name.length() >= 5)) {
            throw new IllegalArgumentException("입력한 자동차 이름중에 5자가 넘는 이름이 있습니다.");
        }
    }

    private void moveCars() {
        List<Car> carList = game.getCarList();
        carList.forEach(car -> {
            int randomDistance = Randoms.pickNumberInRange(0,9);
                    if(randomDistance >= 4) {
                car.updateCarLocation(randomDistance);
            }
            OutputView.outputCarMoveDistance(car.getCarName(), randomDistance);
        });
        System.out.println();
    }

    private void sortFinalWinner(List<Car> carList) {
        List<Car> sortedCars = getSortedCars(carList);
        List<Car> farthestCars = getFarthestCars(sortedCars);
        List<String> winnerCarNames = getWinnerCarNames(farthestCars);
        OutputView.informFinalWinner(winnerCarNames);
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

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}
