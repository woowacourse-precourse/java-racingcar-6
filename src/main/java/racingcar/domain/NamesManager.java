package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class NamesManager {

    public List<String> separateNamesString(String namesString){
        return Arrays.asList(namesString.split(","));
    }

    public boolean checkNamesException(List<String> names){
        for (String name : names){
            if (wrongNameLength(name)){
                return true;
            }
        }

        return false;
    }

    public boolean wrongNameLength(String name) {
        if (name.length() > 5) {
            return true;
        } else {
            return false;
        }
    }

}
