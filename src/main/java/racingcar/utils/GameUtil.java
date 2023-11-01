package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class GameUtil {

    public List<String> splitNamesByComma(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean judgeGo(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

}
