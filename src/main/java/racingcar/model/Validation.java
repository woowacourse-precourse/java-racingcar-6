package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void name(List<String> name) {
        nameLimitLength(name);
        nameNoDuplicate(name);
    }

    private static void nameLimitLength(List<String> name) {
        for (String str : name) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("이름은 5자리 이하만 가능");
            }
        }
    }

    private static void nameNoDuplicate(List<String> name) {
        Set<String> set = new HashSet<>(name);

        if (set.size() != name.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다");
        }
    }
}
