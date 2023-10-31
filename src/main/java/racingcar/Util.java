package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Util {

    public String[] splitString(String input) {
            return input.split(",");
}

    public int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String repeat(String dash, int times) {
        return dash.repeat(times);
    }

    public String join(List<String> arr) {
        return String.join(", ", arr);
    }
}
