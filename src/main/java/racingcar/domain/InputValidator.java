package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public boolean validateCarNames(String cars) throws IllegalArgumentException {
        List<String> carNameList = splitByDelimiter(cars, ",");

        if (carNameList.size() <= 1) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력되어야 합니다");
        }

        for (String carName : carNameList) {
            validateCarName(carName);
        }

        if (hasDuplicatedName(carNameList)) {
            throw new IllegalArgumentException("자동차 이름은 중복되면 안됩니다");
        }

        return true;
    }

    private boolean hasDuplicatedName(List<String> carNameList) {
        Set<String> set = new HashSet<>(carNameList);
        if (set.size() != carNameList.size()) {
            return true;
        }

        return false;
    }

    private static List<String> splitByDelimiter(String cars, String delimiter) {
        List<String> nameList = new ArrayList<>(List.of(cars.split(delimiter)));
        //split 함수의 경우 "효림,현진,"일 때 마지막 공백을 무시하므로 직접 공백 하나를 추가함
        if (cars.length() > 0 && cars.charAt(cars.length() - 1) == ',') {
            nameList.add("");
        }

        return nameList;
    }

    private static void validateCarName(String carName) {
        carName = carName.strip();
        if (carName.length() == 0 || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1이상 5이하여야 합니다");
        }
    }


    public void validateMoveCount(String moveCnt) {
        if (!moveCnt.matches("[0-9]+")) {
            throw new IllegalArgumentException("이동횟수는 자연수여야합니다.");
        }

        if (Integer.parseInt(moveCnt) == 0) {
            throw new IllegalArgumentException("이동횟수는 0이어서는 안됩니다.");
        }
    }
}
