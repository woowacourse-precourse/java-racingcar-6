package racingcar.service.raceservice;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.config.AppConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public interface RaceService {

    <T> Map<Car,T> runRace(Participants participants);
    default int getRandomValue() {
        return Randoms.pickNumberInRange(AppConfig.DISTANCE_MIN, AppConfig.DISTANCE_MAX);
    }
}
