package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Map;

public class GameRanking {
    private final Map<RacingCar, String> participants;

    public GameRanking(Map<RacingCar, String> participants) {
        this.participants = participants;
    }

    public Map<RacingCar, String> progressRound(){
        for(RacingCar racingCar : participants.keySet()){
            participants.replace(racingCar,participants.get(racingCar)
                    + racingCar.apply((Randoms.pickNumberInRange(0,9))).getOutput());
        }
        return Collections.unmodifiableMap(participants);
    }


}
