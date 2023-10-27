package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGenerator {
    private String userInput;
    public CarGenerator(String userInput) {
        this.userInput = userInput;
    }

    public List<String> generateCarNameList() {
        List<String> carNameList = Arrays.stream(userInput.split(",")).toList();
        validateDuplication(carNameList);
        validateEmptyName(carNameList);
        validateNameLength(carNameList);
        return carNameList;
    }

    private void validateDuplication(List<String> carNameList) {
        if (isDuplicated(carNameList)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void validateEmptyName(List<String> carNameList) {
        if (isContainEmpty(carNameList)) {
            throw new IllegalArgumentException("공백인 이름이 있습니다.");
        }
    }

    private void validateNameLength(List<String> carNameList) {
        if (isContainOverMaxLength(carNameList)) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private boolean isDuplicated(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private boolean isContainEmpty(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(String::isEmpty);
    }

    private boolean isContainOverMaxLength(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(name -> name.length() > 5);
    }
}
