package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.core.PickNumber;

import static racingcar.property.RaceProperty.*;

public class Racing {
    private final Racer racer;

    public Racing(Racer racer){
        this.racer=racer;
    }

    public RoundScore racingByRacer(){
        if (racerForward(racerPickNumber())){
            RaceStatus.scoreWriteByRacer(racer, RoundScore.FORWARD);
            return RoundScore.FORWARD;
        }

        RaceStatus.scoreWriteByRacer(racer, RoundScore.STOP);
        return RoundScore.STOP;
    }

    private static boolean racerForward(PickNumber pickNumber){
        return pickNumber.racerPickNumber() >= RACE_FORWARD_STANDARD;
    }

    private static PickNumber racerPickNumber(){
        return ()-> Randoms.pickNumberInRange(PICK_START_POSITION, PICK_END_POSITION);
    }

}
