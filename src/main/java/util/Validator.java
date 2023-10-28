package util;

import java.util.List;

public class Validator {
    private static final int MIN = 1;
    private static final int MAX = 5;

    public void checkCarNamesInput(String input, List<String> carList) throws IllegalArgumentException{
        checkEmpty(input);
        checkLastIndex(input);
        checkDuplicate(carList);
        checkEachSpaceAndLength(carList);
    }

    private void checkEachSpaceAndLength(List<String> carList) {
        for (String carName : carList) {
            checkEachLength(carName);
            checkEachSpace(carName);
        }
    }

    private void checkEachSpace(String carName) {
        if(carName.contains(" ")) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("{ERROR: 자동차 이름에 공백이 있으면 안 됩니다.}");
    }

    private void checkEachLength(String carName) {
        if (MAX < carName.length())
            throwMaxLengthException();
        if (MIN > carName.length()) //ㅁㅁ,(아무것도 존재X),ㅁㅁ
            throwMinLengthException();
    }

    private void checkDuplicate(List<String> carList) {
        for (int i = 0; i < carList.size(); i++)
            compareDuplicate(i, carList);
    }

    private void compareDuplicate(int i, List<String> carList) {
        for (int j = i + 1; j < carList.size(); j++)
            checkEqual(carList.get(i), carList.get(j));
    }

    private void checkEqual(String carName1, String carName2) {
        if(carName1.equals(carName2)) {
            throw new IllegalArgumentException("{ERROR: 동일한 이름의 자동차가 이미 존재합니다.}");
        }
    }

    private void checkLastIndex(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwMinLengthException();
        }
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException("{ERROR: 자동차 이름은" + MIN + "글자 이상이어야 합니다.}");
    }

    private void throwMaxLengthException() {
        throw new IllegalArgumentException("{ERROR: 자동차 이름은" + MAX + "글자 이상이어야 합니다.}");
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("{ERROR: 값이 비어있습니다.}");
        }
    }

    public void checkTrialNumberInput(String input) throws IllegalArgumentException{
        checkEmpty(input);
        checkChar(input);
    }

    private void checkChar(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야만 합니다.");
        }
    }
}
