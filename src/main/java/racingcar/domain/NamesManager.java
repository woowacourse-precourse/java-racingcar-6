package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class NamesManager {

    public List<String> separateNamesString(String namesString){
        return Arrays.asList(namesString.split(","));
    }

    public boolean checkNameLength(String name) {
        if (name.length() > 5) {
            return false;
        } else {
            return true;
        }
    }

}
