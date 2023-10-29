package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private static final String MOVE_UI = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String WINNER = "최종 우승자 : ";

    public String getRaceProgress(List<Car> carList) {
        return carList.stream()
                .map(this::getProgressOfCar)
                .collect(Collectors.joining("\n"))
                + NEW_LINE;
    }

    public String getProgressOfCar(Car car) {
        return car.name() + COLON + displayLocationToUI(car.location());
    }

    public String displayLocationToUI(int location) {
        return MOVE_UI.repeat(location);
    }

    public String getWinners(List<Car> winnerList) {
        return WINNER + winnerList.stream()
                .map(Car::name)
                .collect(Collectors.joining(COMMA));
    }
}
