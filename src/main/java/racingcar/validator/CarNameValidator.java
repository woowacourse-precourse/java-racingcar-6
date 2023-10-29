package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    private static final String TOO_LONG_NAME = "이름은 5자 이하만 가능합니다.";
    private static final String DUPLICATE_NAME = "중복된 이름이 있습니다.";

    public static void checkLength(List<String> carNameList){
        for (String name : carNameList){
            if (name.length() >= 6){
                throw new IllegalArgumentException(TOO_LONG_NAME);
            }
        }
    }

    public static void checkDuplicated(List<String> carNameList){
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }
}
