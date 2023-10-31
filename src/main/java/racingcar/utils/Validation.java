package racingcar.utils;

import java.util.List;

public class Validation {
    public Integer validTryCount(Integer tryCount){
        if (tryCount < 1){
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }
        return tryCount;
    }
    public List<String> validateCarNames(List<String> carNames) {
        boolean fiveUnder = carNames.stream()
                .anyMatch(name ->name.length() > 6);

        if (fiveUnder) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        return carNames;
    }

}
