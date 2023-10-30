package racingcar.domain.dao;

import racingcar.domain.db.CarsData;
import racingcar.domain.db.RaceData;
import racingcar.domain.entity.CarEntity;
import racingcar.domain.entity.RaceEntity;
import racingcar.dto.CarResponse;
import racingcar.dto.RaceResponse;

public class RaceDAO {
    public static void saveAll(RaceResponse newRaceData) {
        RaceData.addRace(new RaceEntity(newRaceData.getAttemptNumber()));
    }

    public static RaceEntity loadAll() {
        return RaceData.getRace();
    }
}
