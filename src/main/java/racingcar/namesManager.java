package racingcar;

import java.util.Arrays;
import java.util.List;

public class namesManager {

    List<String> separateNamesString(String namesString){
        return Arrays.asList(namesString.split(","));
    }

    boolean checkNameLength(String name) {
        if (name.length() > 5) {
            return false;
        } else {
            return true;
        }
    }

}
