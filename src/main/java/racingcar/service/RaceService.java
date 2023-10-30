package racingcar.service;

import static racingcar.constants.RaceRule.MOVE_MAX_RANGE;
import static racingcar.constants.RaceRule.MOVE_MIN_RANGE;
import static racingcar.constants.RaceRule.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RaceProgress;
import racingcar.dto.Progress;

public class RaceService {
    private RaceProgress raceProgress;


    public void init(List<String> carNames) {
        raceProgress = new RaceProgress(carNames);
    }

    public List<Progress> moveCars() {
        for (String carName : raceProgress.getCarList()) {
            if (canMoveForward()) {
                raceProgress.moveSingleCar(carName);
            }
        }
        return getCarProgressList();
    }

    public List<String> getWinner() {
        return raceProgress.getWinners();
    }

    private boolean canMoveForward() {
        int random = Randoms.pickNumberInRange(MOVE_MIN_RANGE.getValue(), MOVE_MAX_RANGE.getValue());
        return random >= MOVE_THRESHOLD.getValue();
    }

    private List<Progress> getCarProgressList() {
        List<Progress> progressList = new ArrayList<>();

        for (String carName : raceProgress.getCarList()) {
            progressList.add(new Progress(carName, raceProgress.getMovedDistance(carName)));
        }
        return progressList;
    }
}
