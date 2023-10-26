package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final String DELIMITER = ",";

    public String[] inputCarNames() {
        String read = Console.readLine();
        String[] names = read.split(DELIMITER);
        validateNameLength(names);
        return names;
    }

    public int inputTryCount() {
        String read = Console.readLine();
        validateIsNumber(read);
        return Integer.parseInt(read);
    }

    private void validateIsNumber(String s) {
        try {
            Integer.parseInt(s);
        }catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateNameLength(String[] names) {
        for(String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하만 입력할 수 있습니다.");
            }
        }
    }
}
