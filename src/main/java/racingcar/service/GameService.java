package racingcar.service;

import racingcar.domain.dao.CarDAO;
import racingcar.dto.CarResponse;

import java.util.List;

public class GameService {
    public static void carsDataSave(List<String> CarNames) {
        for (String carName : CarNames) {
            CarResponse newCarData = new CarResponse(carName);
            CarDAO.saveAll(newCarData);
        }
    }
}
