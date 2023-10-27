package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public List<String> getCarStrings() {
        List<String> carStrings = new ArrayList<>();
        String input = Console.readLine();
        validateNullOrEmpty(input);
        for (String carName : input.split(DELIMITER)) {
            carStrings.add(carName.trim());
        }
        return carStrings;
    }

    public String getRounds() {
        return Console.readLine();
    }

    private void validateNullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 널이거나 빈 문자열입니다.");
        }
    }
}
