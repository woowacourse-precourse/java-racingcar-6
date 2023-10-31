package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import racingcar.util.Util;

public class InputValidator {
    private final Util util;

    public InputValidator() {
        this.util = new Util();
    }

    public void validateCarNames(String carNames) {
        if (util.isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException("검증할 자동차 이름 목록이 없습니다.");
        }

        if (isProperUsingComma(carNames)) {
            throw new IllegalArgumentException("부적절한 ','사용입니다.");
        }

        if (isDuplicateName(carNames)) {
            throw new IllegalArgumentException("이름이 같은 자동차들이 있습니다.");
        }
    }

    public void validateCarName(String carName) {
        if (util.isNullOrEmpty(carName)) {
            throw new IllegalArgumentException("검증할 자동차 이름이 없습니다.");
        }

        String carNamePattern = "^[a-zA-Z가-힣]{1,5}$";
        if (!carName.matches(carNamePattern)) {
            throw new IllegalArgumentException("자동차 이름은 1~5자의 한글, 영어 대소문자로 구성됩니다. " +
                    "한글은 자음, 모음만으로 구성할 수 없습니다.");
        }
    }

    public void validateIterationNumBer(int iterationNumBer) {
        if (iterationNumBer <= 0) {
            throw new IllegalArgumentException("시도 회수는 양수입니다.");
        }
    }

    private boolean isProperUsingComma(String carNames) {
        List<String> carNameList = util.splitByComma(carNames);
        return carNameList.contains("");
    }

    private boolean isDuplicateName(String carNames) {
        List<String> carNameList = util.splitByComma(carNames);
        HashSet<String> duplicationCheckHashSet = new HashSet<>(carNameList);
        return carNameList.size() != duplicationCheckHashSet.size();
    }
}
