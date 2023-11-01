package racingcar.domain;

import java.util.HashSet;
import java.util.List;

public class ValidateCar {
    public void validateName(List<String> carName) {
        HashSet<String> names = new HashSet<>();
        carName.forEach(name -> {
            validateCarName(name);
            validateOverlap(names, name);
        });
    }

    private void validateCarName(String carname) {
        if (carname.length() < 1) {
            throw new IllegalArgumentException(("한 글자 이상의 이름을 적어야 합니다."));
        }
        if (carname.length() > 5) {
            throw new IllegalArgumentException(("다섯 글자 이하의 이름을 적어야 합니다."));
        }
    }

    private void validateOverlap(HashSet<String> names, String name) {
        if (names.contains(name)) {
            throw new IllegalArgumentException("중복된 이름 입니다.");
        }
        names.add(name);
    }
}
