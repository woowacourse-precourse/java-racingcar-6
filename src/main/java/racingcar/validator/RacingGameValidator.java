package racingcar.validator;

import java.util.List;

public class RacingGameValidator {
    private static final String NOT_NORMAL_TERMINATED_GAME = "이동한 자동차가 하나도 없어서 게임이 정상적으로 마무리되지 않았습니다.";

    public void validateGameTerminated(List<Integer> resultList) {
        if (resultList.size() == resultList.stream().filter(value -> value.equals(0)).count()) {
            throw new IllegalArgumentException(NOT_NORMAL_TERMINATED_GAME);
        }
    }
}
