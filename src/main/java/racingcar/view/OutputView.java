package racingcar.view;

import static java.lang.String.format;
import static racingcar.constant.RaceMessage.*;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void carNamesOutput() {
        System.out.println(INIT_CAR_NAMES_MESSAGE.getMessage());
    }

    public void countOutput() {
        System.out.println(INIT_COUNT_MESSAGE.getMessage());
    }

    public void carsDistanceOutput(List<Car> raceCars) {
        for (Car car : raceCars) {
            String name = car.getName();
            int distance = car.getDistance();
            String formattedDistance = CAR_DISTANCE_REPEAT_MESSAGE.getMessage().repeat(distance);
            String raceDistanceMessage = format(RACE_DISTANCE_MESSAGE.getMessage(), name, formattedDistance);
            System.out.println(raceDistanceMessage);
        }
        System.out.println();
    }

    public void winnersOutput(List<String> winners) {
        System.out.println(WINNERS_MESSAGE.getMessage()
                + String.join(WINNERS_DELIMITER.getMessage(), winners));
    }
}
