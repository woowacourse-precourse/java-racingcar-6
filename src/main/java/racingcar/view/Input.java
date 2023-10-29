package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    public List<String> getCarNameList() {
        List<String> carNameList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            validateCarNameLength(carName);
            carNameList.add(carName);
        }

        return carNameList;
    }

    public int getTryCount() {
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCountIfZero(tryCount);
        return tryCount;
    }

    private void validateTryCountIfZero(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}
