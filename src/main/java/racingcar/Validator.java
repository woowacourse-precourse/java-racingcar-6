package racingcar;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    public static void nameDuplicatenCheck(List<String> names) {
        int initLength = names.size();
        HashSet<String> deduplicationSet = new HashSet<>(names);
        if (initLength != deduplicationSet.size()) {
            throw new IllegalArgumentException("중복되지 않은 이름 입력");
        }
    }
}
