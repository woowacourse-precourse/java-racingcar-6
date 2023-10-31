package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NamesManager {

    public List<String> separateNamesString(String namesString) {
        return Arrays.asList(namesString.split(","));
    }

    public boolean checkNamesException(List<String> names) {
        for (String name : names) {
            if (wrongNameLength(name)) {
                return true;
            }
        }

        if (duplicateName(names)) {
            return true;
        }

        return false;
    }

    public boolean wrongNameLength(String name) {
        if (name.length() > 5) {
            return true;
        }

        return false;
    }

    public boolean duplicateName(List<String> names){
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size()!=names.size()){
            return true;
        }

        return false;
    }

}
