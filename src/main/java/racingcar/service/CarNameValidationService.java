package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidationService {

    public void carNameValidation(String carNames) {
        lastCharacterCheck(carNames);

        List<String> carNameList = List.of(carNames.split(","));
        listSizeCheck(carNameList);

        for (String name : carNameList) {
            textLengthCheck(name);
            regexCheck(name);
        }

        duplicateCheck(carNameList);
    }

    private void lastCharacterCheck(String carNames) {
        if (carNames.endsWith(",")) {
            throw new IllegalArgumentException("사용할 수 없는 자동차 이름이 존재합니다.");
        }
    }

    private void listSizeCheck(List<String> carNameList) {
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException("경주할 자동차의 이름은 2개 이상 입력해야 합니다.");
        }
    }

    private void textLengthCheck(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 글자수는 1~5자 사이로 입력해야합니다.");
        }
    }

    private void regexCheck(String name) {
        String pattern = "^[가-힣A-Za-z0-9]*$";

        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("사용할 수 없는 자동차 이름이 존재합니다.");
        }
    }

    private void duplicateCheck(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }


}
