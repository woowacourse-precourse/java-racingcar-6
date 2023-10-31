package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.util.Util;

public class InputValidator {
    private final Util util;

    public InputValidator(Util util) {
        this.util = util;
    }

    public void validateCarNames(String carNames) {
        if (util.isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException("검증할 자동차 이름 목록이 없습니다.");
        }

        String[] carNameArray = carNames.split(",", -1);
        List<String> carNameList = Arrays.asList(carNameArray);

        if (carNameList.contains("")) {
            throw new IllegalArgumentException("부적절한 ','사용입니다.");
        }
        HashSet<String> duplicationCheckHashSet = new HashSet<>(Arrays.asList(carNameArray));

        if (carNameArray.length != duplicationCheckHashSet.size()) {
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
}
