package controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarController {

    private static final String DUPLICATED_NAME = "중복된 이름을 사용할 수 없습니다.";
    private static final String OVER_LIMIT_NAME_LENGTH = "5자 이상의 이름은 입력할 수 없습니다.";
    private static final String COMMA = ",";
    private static final int LIMIT_NAME_LENGTH = 5;

    public void extractName(String input) {
        List<String> nameList = Arrays.asList(input.split(COMMA));
        validateLimitNameLength(nameList);
        Set<String> nameSet = validateDuplicateName(nameList);
    }

    private static void validateLimitNameLength(List<String> nameList) {
        nameList.stream().forEach(name -> {
            if (name.length() > LIMIT_NAME_LENGTH) {
                throw new IllegalArgumentException(OVER_LIMIT_NAME_LENGTH);
            }
        });
    }

    private Set<String> validateDuplicateName(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }

        return nameSet;
    }

}
