package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGame {
    private int farthestDistance;
    private List<RacingCar> racingCarList;
    private int moveCount;

    public RacingCarGame(List<RacingCar> racingCarList, int moveCount) {
        this.racingCarList = racingCarList;
        this.moveCount = moveCount;
        farthestDistance = 0;
    }

    public void run() {
        while (moveCount > 0) {
            moveCarsForward();
            moveCount--;
            RacingCarGameOutput.printGameProgress(racingCarList);
        }
    }

    private boolean isRandomForwardMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    public void moveCarsForward() {
        racingCarList.forEach(car -> {
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

    public List<RacingCar> getWinners() {
        return racingCarList.stream()
                .filter(car -> car.getDistance() == farthestDistance)
                .toList();
    }

}
