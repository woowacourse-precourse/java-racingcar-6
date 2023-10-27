package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.TryRemains;
import racingcar.service.CarMover;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class RaceController {
    TryRemains tryRemains;
    List<Car> carList;

    public RaceController(List<Car> carList) {
        this.carList = carList;
        createTryRemains(InputHandler.inputNumberOfTry());
        doTry();
        // TODO 2023 10 27 최종 우승자 출력
    }

    private void doTry() {
        if (tryRemains.isZero()) {
            return;
        }
        tryRemains.doTry();
        CarMover.move(carList);
        printRaceProgress(carList);
        // TODO 2023 10 27 레이스 진행상황 출력
        doTry();
    }

    private void printRaceProgress(List<Car> carList) {
        OutputHandler.printRaceProgress(carList.stream()
                .map(Car::getNameToString)
                .toList(), carList.stream()
                .map(Car::getProgressToInt)
                .toList());
    }

    private void createTryRemains(String userInput) {
        tryRemains = new TryRemains(Integer.parseInt(userInput));
    }

    //TODO 2023-10-27 12:37:21 CarController에 List<Car>를 반환하는 메서드를 만들고 그 리스트를 받아온다.
}
