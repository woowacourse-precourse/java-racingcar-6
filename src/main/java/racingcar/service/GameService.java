package racingcar.service;

import racingcar.domain.dao.CarDAO;
import racingcar.domain.dao.RaceDAO;
import racingcar.dto.CarResponse;
import racingcar.dto.RaceResponse;

import java.util.List;

public class GameService {
    public static void carsDataSave(List<String> CarNames) {
        for (String carName : CarNames) {
            CarResponse newCarData = new CarResponse(carName);
            CarDAO.saveAll(newCarData);
        }
    }

    public static void raceDataSave(int AttemptNumber) {
        RaceResponse newRaceData = new RaceResponse(AttemptNumber);
        RaceDAO.saveAll(newRaceData);
    }
}
