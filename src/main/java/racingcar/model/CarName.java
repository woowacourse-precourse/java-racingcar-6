package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CarName {
    private String inputCarNames;
    private ArrayList<String> carList = new ArrayList<>();
    private ArrayList<String> clearCarList = new ArrayList<>();

    public void carNamesToList(String inputCarNames) {
        this.inputCarNames = inputCarNames;
        String[] str = inputCarNames.split("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]");
        carList.addAll(Arrays.asList(str));
    }

    public void setClearCarList() {
        isSeperatorNotComma(this.inputCarNames);
        isWrongNameFormat(carList);
        isSameCarName(carList);
        isCarNameLengthOver5(carList);

        clearCarList = carList;
    }

    public ArrayList<String> getClearCarList() {
        return clearCarList;
    }

    public void isWrongNameFormat(ArrayList<String> carList) throws IllegalArgumentException {
        for (String car : carList) {
            if (!car.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳이여야 합니다.");
            }
        }
    }

    public void isSameCarName(ArrayList<String> carList) throws IllegalArgumentException {
        HashSet<String> set = new HashSet<>(carList);
        if (set.size() != carList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
        }
    }

    public void isCarNameLengthOver5(ArrayList<String> carList) throws IllegalArgumentException {
        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
            }
        }
    }

    public void isSeperatorNotComma(String inputCarNames) throws IllegalArgumentException {
        int cnt = 0;
        for (Character c : inputCarNames.toCharArray()) {
            if (c == ',') {
                cnt++;
            }
        }
        if (cnt != carList.size() - 1) {
            throw new IllegalArgumentException("구분자는 자동차 이름 사이의 쉼표입니다.");
        }
    }
}
