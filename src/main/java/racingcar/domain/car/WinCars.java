package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.carcomponent.CarPositionCompareResult;

public class WinCars {
    private static final String DELIMITER_WIN_CAR = ", ";
    private static final String WIN_CAR_MESSAGE = "최종 우승자 : ";
    private final List<Car> winCars;

    public WinCars() {
        this.winCars = new ArrayList<>();
    }

    public void checkCarWinGame(Car car) {
        if (winCars.isEmpty()) {
            winCars.add(car);
            return;
        }
        Car higestCar = winCars.get(0);
        CarPositionCompareResult compareResult = car.comparePosition(higestCar);
        if (compareResult.isBig()) {
            winCars.clear();
        }
        if (!compareResult.isSmall()) {
            winCars.add(car);
        }
    }

    public String getWinCars() {
        String winCar = winCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(DELIMITER_WIN_CAR));
        return WIN_CAR_MESSAGE + winCar;
    }
}
