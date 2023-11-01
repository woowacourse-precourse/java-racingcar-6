package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Validator;

public class InputView {

    public static List<Car> inputCarNames() {
        OutputView.printRequestCarNames();
        String input = Console.readLine();
        return Validator.parseCarNames(input);
    }

    public static int inputNumberOfTurns() {
        OutputView.printRequestNumberOfTurns();
        String input = Console.readLine();
        return Validator.parseNumberOfTurns(input);
    }
}
