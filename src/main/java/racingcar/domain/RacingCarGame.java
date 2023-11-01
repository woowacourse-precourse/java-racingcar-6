package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingCar;
import racingcar.utils.RandomUtil;

public class RacingCarGame {
    private int farthestDistance;
    private List<RacingCar> racingCarList;
    private int moveCount;

    public RacingCarGame(List<RacingCar> racingCarList, int moveCount) {
        this.racingCarList = racingCarList;
        this.moveCount = moveCount;
        farthestDistance = 0;
    }

    public void run(RandomUtil util) {
        while (moveCount > 0) {
            moveCarsForward(util);
            moveCount--;
            RacingCarGameOutput.printGameProgress(racingCarList);
        }
    }

    private boolean isRandomForwardMove(RandomUtil util) {
        return util.getRandomValue() >= 4;
    }

    private void moveCarsForward(RandomUtil util) {
        racingCarList.forEach(car -> {
            if (isRandomForwardMove(util)) {
                car.moveForword();
                updateFarthestDistance(car.getDistance());
            }
        });
    }

    private void updateFarthestDistance(int distance) {
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
