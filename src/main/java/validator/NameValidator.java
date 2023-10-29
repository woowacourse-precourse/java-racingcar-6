package validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NameValidator {
    private static final String COUNT_OF_NAME_ERROR_MESSAGE = "[ERROR] 두 개 이상의 이름을 입력해 주세요.";
    private final static String DUP_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "[Error] 1자 이상, 5자 이하의 이름을 입력해 주세요.";
    private static final String CONTAIN_ERROR_MESSAGE = "[Error] 포함될 수 없는 문자가 포함되어 있습니다.";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";

    private static final int MIN_COUNT_OF_NAME = 2;

    public static List<String> nameValidator(List<String> nameList) {
        validateCountOfName(nameList);
        validateNameDup(nameList);
        validateLength(nameList);
        validateContain(nameList);

        return nameList;
    }

    public static void validateCountOfName(List<String> nameList) {
        if (nameList.size() < MIN_COUNT_OF_NAME) {
            throw new IllegalArgumentException(COUNT_OF_NAME_ERROR_MESSAGE);
        }
    }

    private static void validateNameDup(List<String> nameList) {
        Set<String> nameSet = nameList.stream().collect(Collectors.toSet());

        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(DUP_ERROR_MESSAGE);
        }
    }

    private static void validateLength(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static void validateContain(List<String> nameList) {
        for (String name : nameList) {
            if (name.contains(SPACE)) {
                throw new IllegalArgumentException(CONTAIN_ERROR_MESSAGE);
            }
        }
    }
}
