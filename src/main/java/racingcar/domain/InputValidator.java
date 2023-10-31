package racingcar.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static HashMap<String, Integer> validateInput(String input) {
        HashMap<String, Integer> namesMap = new HashMap<>();
        Set<String> nameSet = new HashSet<>();

        String[] names = input.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 2대 이상의 자동차가 필요합니다.");
        }

        for (String name : names) {
            String trimmedName = name.trim(); // 앞 뒤 공백은 허용
            if (trimmedName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 띄어쓰기가 포함되면 안 됩니다.");
            }

            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
            }

            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            namesMap.put(trimmedName, 0);
        }

        return namesMap;
    }
}
