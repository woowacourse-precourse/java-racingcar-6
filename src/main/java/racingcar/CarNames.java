package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public List<String> inputCarNames() {
        String rawCarNames = Console.readLine();
        return splitCarNames(rawCarNames);
    }

    private List<String> splitCarNames(String rawCarNames) {
        List<String> splitCarNames = new ArrayList<>();
        String nowCarNames = rawCarNames;

        if (rawCarNames.contains(",")) {


            while (nowCarNames.contains(",")) {
                int index = nowCarNames.indexOf(",");
                String tempCarNames = nowCarNames.substring(0, index);
                checkAndthenAdd(tempCarNames, splitCarNames);
                nowCarNames = nowCarNames.substring(index + 1);
            }
        }
        if(!nowCarNames.isEmpty()) {
            checkAndthenAdd(nowCarNames, splitCarNames);

        }
        if(nowCarNames.isEmpty()) {
            checkAndthenAdd(rawCarNames, splitCarNames);
        }
        return splitCarNames;
    }

    private void checkCarNameSize(String carName) {
        if (carName.length() > 5 || (carName.length() == 0)) {
            throw new IllegalArgumentException("자동차의 이름은 다섯 글자를 초과할수 없습니다");
        }
    }

    private void checkSameCarName(List<String> splitCarName, String compareCarName) {
        if (splitCarName.contains(compareCarName)) {
            throw new IllegalArgumentException("서로 다른 차량의 이름을 입력해주세요");
        }
    }

    private void checkAndthenAdd(String carName, List<String> splitCarNames) {
        checkCarNameSize(carName);
        checkSameCarName(splitCarNames, carName);
        splitCarNames.add(carName);
    }
}
