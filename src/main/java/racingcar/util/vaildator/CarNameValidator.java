package racingcar.util.vaildator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MAX_INPUT_NAME_SIZE = 5;
    private static final int MININUM_CARLIST_SIZE = 2;
    private static final String INPUT_NAME_SIZE_EXCEPTION = "이름이 5자를 초과하였습니다.";
    private static final String INPUT_NAME_EXCEPTION = "이름을 입력해주세요.";
    private static final String INPUT_NAME_MINIMUM_EXCEPTION = "2명 이상 입력해주세요.";
    private static final String INPUT_NAME_DUPLICATE_EXCEPTION = "중복된 이름이 존재합니다.";

    public static void validateInputNameSize(String name) {
        if (name.length() > MAX_INPUT_NAME_SIZE) {
            throw new IllegalArgumentException(INPUT_NAME_SIZE_EXCEPTION);
        }
    }

    public static void validateInputName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NAME_EXCEPTION);
        }
    }

    public static void validateMinimumCarNameCount(List<String> carList) {
        if (carList.size() < MININUM_CARLIST_SIZE) {
            throw new IllegalArgumentException(INPUT_NAME_MINIMUM_EXCEPTION);
        }
    }

    public static void validateInputNameDupication(List<String> carList) {
        Set<String> duplicateCarList = new HashSet<>(carList);
        if (carList.size() != duplicateCarList.size()) {
            throw new IllegalArgumentException(INPUT_NAME_DUPLICATE_EXCEPTION);
        }
    }

}
