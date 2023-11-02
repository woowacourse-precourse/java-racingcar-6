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
        int cntOfMaxMove = getMaxCntMoveOfRaceCar(raceCarList);
        boolean isVictory = true;

        for (RaceCar raceCar : raceCarList) {
            isVictory = judgeStandard.isVictory(raceCar, cntOfMaxMove);

            if (isVictory) {
                winnerList.add(raceCar);
            }
        }

        return winnerList;
    }

    /**
     * RaceCar 움직인 count중 최고로 많은 횟수를 반환
     *
     * @param raceCarList
     * @return
     */
    public Integer getMaxCntMoveOfRaceCar(List<RaceCar> raceCarList) {
        int max = raceCarList.stream()
                .mapToInt(RaceCar::getCntMovement)
                .max()
                .orElse(0);
        return max;
    }
}
