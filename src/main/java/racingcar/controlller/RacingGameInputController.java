package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Parser;
import racingcar.view.InputView;

public class RacingGameInputController {
    public static Cars scanCarList() {
        System.out.println(InputView.enterCarNames());
        String userInput = Console.readLine();
        RacingGameInputValidator.validateCarList(userInput);

        return createCarList(userInput);
    }

    private static Cars createCarList(String userInput) {
        List<Car> carList = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new Cars(carList);
    }

    public static Integer scanNumberOfRounds() {
        System.out.println(InputView.enterNumberOfRounds());
        String userInput = Console.readLine();
        RacingGameInputValidator.validateNumberOfRounds(userInput);

        return createNumberOfRounds(userInput);
    }

    private static Integer createNumberOfRounds(String userInput) {
        return Integer.parseInt(userInput);
    }
}
