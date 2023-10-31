package racingcar.game.director;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.car.Car;

public class Rule {
    private static final String RACE_SITUATION = "-";

    public String countToHyphen(Car car) {
        StringBuilder stringBuffer = new StringBuilder();
        Integer roundPoint = car.getForwardCount();
        stringBuffer.append(RACE_SITUATION.repeat(Math.max(0, roundPoint)));
        return String.valueOf(stringBuffer);
    }

    public List<Car> findWinners(List<Car> carList) {
        int maxForwardCount = carList.stream().mapToInt(Car::getForwardCount).max().orElseThrow();

        return carList.stream().filter(car -> car.getForwardCount() == maxForwardCount)
                .collect(Collectors.toList());
    }

}
