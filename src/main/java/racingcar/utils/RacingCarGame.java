package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGame {
    private int farthestDistance;

    public RacingCarGame() {
        farthestDistance = 0;
    }

    private boolean isRandomForwardMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    public void moveCarsForward(List<RacingCar> carList) {
        carList.forEach(car -> {
            if (isRandomForwardMove()) {
                car.moveForword();
                updateFarthestDistance(car.getDistance());
            }
        });
    }

    public void updateFarthestDistance(int distance) {
        if (farthestDistance < distance) {
            farthestDistance = distance;
        }
    }

    public List<RacingCar> getWinners(List<RacingCar> carList) {
        return carList.stream()
                .filter(car -> car.getDistance() == farthestDistance)
                .toList();
    }

}
