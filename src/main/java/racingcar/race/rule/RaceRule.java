package racingcar.race.rule;

import java.util.List;
import racingcar.car.model.Car;

public interface RaceRule {
//    boolean isMovable();
    void round(List<Car> participantList);
    List<String> getWinner(List<Car> participantList);
}
