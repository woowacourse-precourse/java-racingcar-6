package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class View {
    private final String DELIMITER = ",";

    public String[] inputCarNames() {
        String read = Console.readLine();
        String[] names = read.split(DELIMITER);
        validateNameLength(names);
        return names;
    }

    private void validateNameLength(String[] names) {
        for(String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하만 입력할 수 있습니다.");
            }
        }
    }
}
