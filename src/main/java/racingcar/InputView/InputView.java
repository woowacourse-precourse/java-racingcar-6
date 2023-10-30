package racingcar.InputView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Validator;

public class InputView {
    private Validator validator = new Validator();

    public List<String> getCarNames() {
        List<String> names = new ArrayList<>();

        while (names.isEmpty()) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            validator.validateCarName(carNames);
            names = Arrays.asList(carNames.split(","));
        }
        return names;
    }
}
