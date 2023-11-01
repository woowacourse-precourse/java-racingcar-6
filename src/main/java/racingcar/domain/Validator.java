package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Validator {
    Validator() {
    }

    void validateSize(List<String> names) {
        int size = names.size();
        if (size < 2 || size > 100) {
            throw new IllegalArgumentException("자동차의 수는 2대 이상 100대 이하만 가능합니다.");
        }
    }

    void validateNamePattern(List<String> names) {
        for (String name : names) {
            if (!name.matches("^[a-zA-Z]{1,5}$")) {
                throw new IllegalArgumentException("입력한 이름이 올바르지 않습니다.");
            }
        }
    }

    void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("이름에 중복이 존재합니다.");
            }
        }
    }

    void validateRaceCountRange(int raceCount) {
        if (raceCount == 0 || raceCount > 100) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 100 이하만 가능합니다.");
        }
    }
}
