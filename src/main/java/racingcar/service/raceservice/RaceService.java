package racingcar.service.raceservice;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.AppConfig;
import racingcar.model.Participants;

public interface RaceService {

    Map runRace(Participants participants);
    default int getRandomValue(){
        return Randoms.pickNumberInRange(AppConfig.DISTANCE_MIN, AppConfig.DISTANCE_MAX);
    }
}
