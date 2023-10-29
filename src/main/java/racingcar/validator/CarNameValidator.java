package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    public static void checkLength(List<String> carNameList){
        for (String name : carNameList){
            if (name.length() >= 6){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkDuplicated(List<String> carNameList){
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException();
        }
    }
}
