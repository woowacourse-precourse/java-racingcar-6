package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.car.CarMovementDecider;
import racingcar.dto.Car;
import racingcar.view.OutputView;

public class GameEngine {
    private static final CarInfo carInfo = CarInfo.getInstance();

    public void processTurn() {
        for (Car currentCar : carInfo.getAllCarInfo()) {
            CarMovementDecider decider = new CarMovementDecider(currentCar);

            printStatusOfRaceCar(currentCar.name(), decider.decideMovement());
        }
    }

    private void printStatusOfRaceCar(String name, Integer position) {
        if (position != null) {
            String messageToPrint = name + " : " + "-".repeat(position);
            OutputView.printOutputMessage(messageToPrint);
        }
    }

    public List<Car> findWinner() {
        List<Car> winnerList = carInfo.getAllCarInfo();

        int maxPosition = winnerList.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalStateException("차량 목록이 비어있습니다."));

        return winnerList.stream()
                .filter(car -> car.position() == maxPosition)
                .toList();
    }
}

