package racingcar.model;

import java.util.List;
import racingcar.model.car.CarDTO;

public class JudgeWinnerImpl implements JudgeWinner {

    @Override
    public List<CarDTO> judge(Cars cars) {
        return cars.judge();
    }

}
