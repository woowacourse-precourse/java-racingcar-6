package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.Constant.*;

public class GameView {
    public List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Arrays.asList(readLine().split(","));
    }
}