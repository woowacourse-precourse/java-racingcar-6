package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.car.CarMovement;
import racingcar.dto.Car;
import racingcar.view.OutputView;

public class GameEngine {
    private static final CarInfo carInfo = CarInfo.getInstance();

    public void moveCarsOfUser() {
        carInfo.getAllCarInfo().stream()
                .map(currentCar -> (new CarMovement(currentCar)).car())
                .forEach(OutputView::printStatusOfRaceCar);
    }

    public List<Car> findWinnerCar() {
        List<Car> carList = carInfo.getAllCarInfo();

        int maxPosition = carList.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalStateException("차량 목록이 비어있습니다."));

        return carList.stream()
                .filter(car -> car.position() == maxPosition)
                .toList();
    }
}

