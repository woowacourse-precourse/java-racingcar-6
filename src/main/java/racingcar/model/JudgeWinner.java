package racingcar.model;

import java.util.List;
import racingcar.model.car.CarDTO;

public interface JudgeWinner {

    List<CarDTO> judge(Cars cars);
}
