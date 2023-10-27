package racingcar.Controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceController {
    public void raceStart() {

         pickRandomNum();

    }
    private int pickRandomNum(){
        return pickNumberInRange(1,9);
    }
}