package racingcar.model;

import java.util.List;
import racingcar.model.Car;

public interface JudgeWinner {

    List<CarDTO> judge(Cars cars);
}
