package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public final class RacingStatus {
    private static final String MOVE_UI = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String WINNER = "최종 우승자 : ";

    public String getRaceProgress(List<Car> carList) {
        return carList.stream()
                .map(this::getProgressOfCar)
                .collect(Collectors.joining(NEW_LINE))
                + NEW_LINE;
    }

    public String getProgressOfCar(Car car) {
        return car.getCarName() + COLON + displayLocationToUI(car.getCarLocation());
    }

    private String displayLocationToUI(int location) {
        return MOVE_UI.repeat(location);
    }

    public String getWinners(List<Car> winnerList) {
        return WINNER + winnerList.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(COMMA));
    }
}
