package racingcar.util;

import java.util.List;

public class Checker {

    private final Parser parser = new Parser();

    public void checkCarNamesInput(String carName) throws IllegalArgumentException {
        checkEmptyCarName(carName);
        List<String> carNameList = parser.parseCarNames(carName);
        checkDuplicateCarNameList(carNameList);
        checkEachCarNameLength(carNameList);
    }

    private void checkEachCarNameLength(List<String> carNameList) {
        for (String carName : carNameList) {
            checkCarNameLength(carName);
            checkEmptyCarName(carName);
        }
    }

    private void checkDuplicateCarNameList(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkDuplicateCarName(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    public void checkCarNameLength(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한 글자 이상이어야 합니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 다섯 글자 이하여야 합니다.");
        }
    }

    private void checkDuplicateCarName(String carNameOne, String carNameTwo) {
        if (carNameOne.equals(carNameTwo)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 중 중복이 존재합니다.");
        }
    }

    private void checkEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 중 공백이 존재합니다.");
        }
    }

}