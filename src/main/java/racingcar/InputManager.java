package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputManager {
    public List<String> getNames() {
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));

        validateNotSameName(names);
        validateNameLength(names);

        return names;
    }

    private void validateNameLength(List<String> names) {
        for (String name: names) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("[입력오류] 1글자 이상, 5글자 이하의 이름만 가능합니다.");
            }
        }
    }

    private void validateNotSameName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() > nameSet.size()) {
            throw new IllegalArgumentException("[입력오류] 동일한 이름이 입력되었습니다.");
        }
    }

    public int getTimes() {
        String input = Console.readLine();
        try {
            int times = Integer.parseInt(input);
            if (times < 0) {
                throw new IllegalArgumentException("[입력오류] 자연수를 입력해야 합니다.");
            }
            return times;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[입력오류] 정수를 입력해야 합니다.");
        }
    }
}
