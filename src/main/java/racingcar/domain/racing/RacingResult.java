package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

public class RacingResult {

    public static List<String> getFinalWinners(RacingCars cars) {
        int maxPosition = cars.getMaxPosition();
        for(RacingCar car : cars.getCars()) {
            System.out.printf("%s %d\n", car.getName(), car.getPosition());
        }

        List<RacingCar> result = cars.getCars().stream().filter(car -> car.getPosition() == maxPosition).toList();
        return result.stream().map(RacingCar::getName).toList();
    }
}
