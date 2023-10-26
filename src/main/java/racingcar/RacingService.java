package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingService {
    public void move(List<Car> carList) {
        carList.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.moveForward();
            }
        });
    }

    public List<Car> getWinner(List<Car> carList) {
        Integer maxPosition = carList.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
