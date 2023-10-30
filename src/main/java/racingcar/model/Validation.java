package racingcar.model;

import java.util.List;

public class Validation {

    static void nameLimitLength(List<String> name) {
        for (String str : name) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("이름은 5자리 이하만 가능");
            }
        }
    }

}
