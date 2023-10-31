package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateName(List<String> names) {
        Set<String> checkDuplicateName = new HashSet<>();

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            checkDuplicateName.add(name);
        }

        if(checkDuplicateName.size()!=names.size()){
            throw new IllegalArgumentException();
        }
    }
}
