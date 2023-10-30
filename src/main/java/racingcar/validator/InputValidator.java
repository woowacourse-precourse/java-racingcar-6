package racingcar.validator;

import static racingcar.gameutil.GameConstants.*;

import java.util.Arrays;
import racingcar.gameutil.GameConstants;

public class InputValidator {

    private final String CAR_NAME_REGEX = "\\w+(\\s+\\w+)*(,\\w+(\\s+\\w+)*)*"; // ,뒤 공백은 비허용/이름 사이 공백은 허용
    private final String TRY_COUNT_REGEX = "[1-9]\\d*";

    public void validateInputCarName(String carName) {
        String[] names = carName.split(",");

        checkValidatedCarName(carName);
        checkDuplicateCarName(names);
        checkParticipantSizeUnderTwo(names);
        checkNameLengthOverFive(names);
    }

    public void validateInputTryCount(String tryCount) {
        if (!tryCount.matches(TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException("맨 앞의 0은 허용되지 않습니다. 알맞은 숫자를 입력해주세요.");
        }
    }

    private void checkValidatedCarName(String carName) {
        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(",뒤 공백은 허용되지 않습니다.");
        }
    }

    private void checkDuplicateCarName(String[] names) {
        long nonDuplicatedNameSize = Arrays.stream(names)
                .distinct()
                .count();

        if (nonDuplicatedNameSize != names.length) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private void checkParticipantSizeUnderTwo(String[] names) {
        if (names.length < CAR_SIZE_MIN) {
            throw new IllegalArgumentException("참가하는 자동차는 2대 이상이어야 합니다.");
        }
    }

    private void checkNameLengthOverFive(String[] names) {
        for (String name : names) {
            if (name.length() > CAR_NAME_MAX_LEN) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5자를 넘을 수 없습니다.");
            }
        }
    }
}
