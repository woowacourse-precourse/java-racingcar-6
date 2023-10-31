package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHost {
    JudgeStandard judgeStandard;

    public GameHost() {
        this.judgeStandard = new JudgeStandard();
    }

    public List<RaceCar> giveWinnerList(List<RaceCar> raceCarList) {
        List<RaceCar> winnerList = new ArrayList<>();
        int cntOfMaxMove = getMaxCntMove(raceCarList);
        boolean isVictory = true;

        for (RaceCar raceCar : raceCarList) {
            isVictory = judgeStandard.isVictoryCondition(raceCar, cntOfMaxMove);

            if (isVictory) {
                winnerList.add(raceCar);
            }
        }

        return winnerList;
    }

    public Integer getMaxCntMove(List<RaceCar> progressCarList) {
        int max = progressCarList.stream()
                .mapToInt(RaceCar::getCntMovementOfCar)
                .max()
                .orElse(0);
        return max;
    }
}
