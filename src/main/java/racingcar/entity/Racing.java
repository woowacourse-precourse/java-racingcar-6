package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.core.PickNumber;

import static racingcar.property.RaceProperty.*;

public class Racing {
    private final Racer racer;

    public Racing(Racer racer){
        this.racer=racer;
    }

    public Integer racingByRacer(){
        if (racerForward(racerPickNumber())){
            return RaceStatus.scoreWriteByRacer(racer,RoundResult.FORWARD);
        }

        return RaceStatus.scoreWriteByRacer(racer,RoundResult.STOP);
    }

    private static boolean racerForward(PickNumber pickNumber){
        return pickNumber.racerPickNumber() >= RACE_FORWARD_STANDARD;
    }

    private static PickNumber racerPickNumber(){
        return ()-> Randoms.pickNumberInRange(PICK_START_POSITION, PICK_END_POSITION);
    }

}
