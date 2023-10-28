package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String COMMA = ",";

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (String name : Console.readLine().split(COMMA)) {
            if (!name.isBlank() && !name.isEmpty()) {
                carNames.add(name);
            }
        }
        return carNames;
    }

    public String getRacingTrial() {
        return Console.readLine();
    }
}
