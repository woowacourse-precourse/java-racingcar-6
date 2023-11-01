package racingcar.service;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.dto.CarStatusDto;

public class WinnerSelectionService {

    public List<CarStatusDto> selectWinners(Cars cars) {
        return cars.getWinners();
    }

}
