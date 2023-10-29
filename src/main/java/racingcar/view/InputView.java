package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import util.Validator;

public final class InputView {

    public static List<Car> getCarNames() {
        OutputView.displayInitCarNames();
        String input = Console.readLine();
        return Validator.parseCarNames(input);
    }

    public static int getNumberOfAttempts() {
        OutputView.displayInitNumberOfAttempts();
        String input = Console.readLine();
        return Validator.parseNumberOfAttempts(input);
    }
}
