package racingcar.model;

import java.util.List;

public class JudgeWinnerImpl implements JudgeWinner {

    @Override
    public List<String> judge(Cars cars) {
        return cars.judgeMaxStep();
    }

}
