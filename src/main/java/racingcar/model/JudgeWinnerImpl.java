package racingcar.model;

import java.util.List;

public class JudgeWinnerImpl implements JudgeWinner {

    @Override
    public List<CarDTO> judge(Cars cars) {
        return cars.judge();
    }

}
