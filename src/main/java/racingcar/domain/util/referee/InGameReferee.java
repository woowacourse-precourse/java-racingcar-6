package racingcar.domain.util.referee;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.config.GameConfig;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.valueobject.CarLocation;

public class InGameReferee {
    private static final int LOWER_LIMIT = GameConfig.LOWER_LIMIT;

    public int getLOWER_LIMIT_Fortest() {
        return LOWER_LIMIT;
    }

    public static boolean isBiggerLowerLimit(int generatedNumber) {
        return generatedNumber >= LOWER_LIMIT;
    }

    public static List<Car> findWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();

        CarLocation maxLocation = findBiggest(cars);
        for (Car car : cars) {
            if (car.getLocation().equals(maxLocation)) {
                winner.add(car);
            }
        }

        return winner;
    }

    private static CarLocation findBiggest(List<Car> cars) {
        CarLocation maxLocation = new CarLocation();

        for (Car car : cars) {
            if (car.getLocation().getInteger() > maxLocation.getInteger()) {
                maxLocation = car.getLocation();
            }
        }

        return maxLocation;
    }
}
