package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        String inputCarNames = Console.readLine();
        InputValidation.validateInput(inputCarNames);

        StringTokenizer st = new StringTokenizer(inputCarNames);
        while (st.hasMoreTokens()) {
            carNames.add(String.valueOf(st));
        }
        InputValidation.validateCarNames(carNames);

        return carNames;
    }
}