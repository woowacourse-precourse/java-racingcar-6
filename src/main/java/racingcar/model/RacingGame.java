package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;

public class RacingGame {
    private List<Car> carGroup;

    public void init(List<CarName> carNames) {
        carGroup = new ArrayList<>();
        carNames.forEach((name) -> carGroup.add(new Car(name)));
    }

    public String playGame(Attempt attempt) {
        String result = "";
        for (int i = 0; i < attempt.getCount(); i++) {
            for (Car car : carGroup) {
                car.playGameOneRound();
                result += (car.toString() + System.lineSeparator());
            }
            result += System.lineSeparator();
        }
        return result;
    }
}
