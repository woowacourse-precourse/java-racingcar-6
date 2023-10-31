package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHost {
    JudgeStandard judgeStandard;

    public GameHost() {
        this.judgeStandard = new JudgeStandard();
    }

    /**
     * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
     *
     * @param progressRaceCarList 현제 진행중인 RaceCarList
     * @return
     */
    public List<RaceCar> giveWinnerRaceCarList(List<RaceCar> progressRaceCarList) {
        List<RaceCar> raceCarOfWinnerList = new ArrayList<>();
        int cntOfMaxMove = getCntMaxMove(progressRaceCarList);
        boolean isVictoryOfRace = true;

        for (RaceCar raceCarOfCurrentProgress : progressRaceCarList) {
            isVictoryOfRace = judgeStandard.isVictoryCondition(raceCarOfCurrentProgress, cntOfMaxMove);

            if (isVictoryOfRace) {
                raceCarOfWinnerList.add(raceCarOfCurrentProgress);
            }
        }
        return raceCarOfWinnerList;
    }

    /**
     * 현제 레이싱을 하는 자동차의 움직인 횟수중에
     * 최고로 많은 횟수를 알려준다.
     *
     * @param progressCarList
     * @return
     */
    public Integer getCntMaxMove(List<RaceCar> progressCarList) {
        int max = progressCarList.stream()
                .mapToInt(RaceCar::getCntMovementOfCar)
                .max()
                .orElse(0);
        return max;
    }
}
