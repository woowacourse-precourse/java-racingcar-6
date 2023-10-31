package racingcar.models;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    private final List<CarStatus> carStatuses = new ArrayList<>();

    public void addCarStatus(CarStatus carStatus) {
        carStatuses.add(carStatus);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CarStatus carStatus : carStatuses) {
            stringBuilder.append(carStatus.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
