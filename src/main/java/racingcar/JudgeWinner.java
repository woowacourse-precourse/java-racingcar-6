package racingcar;

import java.util.List;
import racingcar.model.Car;

public interface JudgeWinner {

    List<String> judge(List<Car> cars);
}
