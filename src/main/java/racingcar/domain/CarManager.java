package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.FinalResult;
import racingcar.dto.ProgressState;
import racingcar.view.ConsoleInput;

public class CarManager {
    private static List<Car> carList;

    public static void makeCarList(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public static void proceed() {
        carList.forEach(CarManager::proceedEachCar);
    }

    public static ProgressState getState() {
        return ProgressState.create(carList);
    }

    private static void proceedEachCar(Car car) {
        int progress = ConsoleInput.inputProgress();
        car.go(progress);
    }

    public static FinalResult getFinalWinner() {
        int maxProgress = Collections.max(
                carList.stream()
                        .map(Car::getProgress)
                        .toList());

        List<Car> maxCarList = carList.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .toList();

        return FinalResult.create(maxCarList);
    }

}
