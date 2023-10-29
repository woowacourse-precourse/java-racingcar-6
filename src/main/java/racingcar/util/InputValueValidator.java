package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValueValidator {

    public List<String> validateName(String inputCarNames) {
        List<String> carNames = converStringToList(inputCarNames);

        // TODO: Null 값, 공백 미포함 유효성 검사 추가
        if (!isDuplicateName(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름은 중복을 허용하지 않습니다.");
        } else if (!isNameLength(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름 길이는 5자 이하만 가능합니다.");
        }
        return carNames;
    }

    private boolean isDuplicateName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        return set.size() == carNames.size();
    }

    private boolean isNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
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
