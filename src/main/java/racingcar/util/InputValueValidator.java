package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValueValidator {

    public List<String> validateName(String inputCarNames) {
        List<String> carNames = converStringToList(inputCarNames);

        if (!isDuplicateName(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름은 중복을 허용하지 않습니다.");
        } else if (!isCarNameLength(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름 길이는 5자 이하만 가능합니다.");
        } else if(!isMinimumTwoCarNames(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 최소 2개 이상의 이름을 입력해주세요.");
        }
        return carNames;
    }

    private boolean isDuplicateName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        return set.size() == carNames.size();
    }

    private boolean isCarNameLength(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= 5);
    }

    private boolean isMinimumTwoCarNames(List<String> carNames) {
        return carNames.size() > 1;
    }

    public int validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("잘못된 입력입니다. 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
        return tryNumber;
    }

    private List<String> converStringToList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }
}
