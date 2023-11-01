package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NamesManager {

    private static final int MAX_NAME_LENGTH = 5;

    public List<String> separateNamesString(String namesString) {
        return Arrays.asList(namesString.split(","));
    }

    public void checkNamesException(List<String> names) {
        for (String name : names) {
            wrongNameLength(name);
        }
        duplicateName(names);
    }

    private void wrongNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("6 글자 이상인 이름이 있는지 확인해주세요.");
        }
    }

    private void duplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException("중복되는 이름이 있는지 확인해주세요.");
        }
    }

}
