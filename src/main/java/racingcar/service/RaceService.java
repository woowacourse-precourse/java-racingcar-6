package racingcar.service;

import static racingcar.constants.RaceRule.MOVE_MAX_RANGE;
import static racingcar.constants.RaceRule.MOVE_MIN_RANGE;
import static racingcar.constants.RaceRule.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RaceProgress;
import racingcar.dto.Progress;
import racingcar.dto.Setup;

public class RaceService {
    private RaceProgress raceProgress;
    private int tryCount;


    public void init(Setup setup) {
        raceProgress = new RaceProgress(setup.carNames());
        tryCount = setup.tryCount();
    }

    public List<Progress> moveCars() {
        for (String carName : raceProgress.getCarList()) {
            moveSingleCar(carName);
        }
        decreaseTryCount();
        return getCarProgressList();
    }

    private void moveSingleCar(String carName) {
        if (canMoveForward()) {
            raceProgress.addMovedDistance(carName);
        }
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


    public boolean isRaceInProgress() {
        return tryCount > 0;
    }

    private void decreaseTryCount() {
        this.tryCount--;
    }
}
