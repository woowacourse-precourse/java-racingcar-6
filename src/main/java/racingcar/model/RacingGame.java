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

    public String determineWinner() {
        String result = "";
        int max = getMaxDistance();
        // find winner with max distance
        List<String> winnerList = new ArrayList<>();
        for (Car car : carGroup) {
            if (car.getCarLocationLength() == max) {
                winnerList.add(car.getName().toString());
            }
        }
        // return winner
        return String.join(", ", winnerList);
    }

    private int getMaxDistance() {
        int max = 0;
        for (Car car : carGroup) {
            int distance = car.getCarLocationLength();
            if (distance > max) {
                max = distance;
            }
        }
        return max;
    }
}
