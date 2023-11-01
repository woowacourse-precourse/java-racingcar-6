package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarNameValidator implements Validator<List<String>> {

    @Override
    public void validate(List<String> target) {
        validateByLength(target);
        validateByCharacter(target);
        validateDuplicateNames(target);
    }

    private void validateByLength(List<String> target) {
        for (String name : target) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 너무 깁니다. 현재 길이 : " + name.length());
            } else if (name.length() < 1) {
                throw new IllegalArgumentException("자동차 이름이 너무 짧습니다. 현재 길이 : " + name.length());
            }
        }
    }

    private void validateByCharacter(List<String> target) {
        for (String name : target) {
            if (!name.matches("^[0-9a-zA-Z가-힣]+$")) {
                throw new IllegalArgumentException("자동차 이름으로 올바르지 않은 문자가 입력되었습니다.");
            }
        }
    }

    private void validateDuplicateNames(List<String> target) {
        Set<String> nameSet = new HashSet<>();
        for (String name : target) {
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
            nameSet.add(name);
        }
    }
}
