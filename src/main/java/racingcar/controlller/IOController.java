package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class IOController {
    // Input
    public static Cars scanCarList() {
        System.out.println(InputView.enterCarNamesMessage());
        String userInput = Console.readLine();
        InputValidator.validateCarList(userInput);

        return createCarList(userInput);
    }

    private static Cars createCarList(String userInput) {
        List<Car> carList = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new Cars(carList);
    }

    public static Integer scanNumberOfRounds() {
        System.out.println(InputView.enterNumberOfRoundsMessage());
        String userInput = Console.readLine();
        InputValidator.validateNumberOfRounds(userInput);

        return createNumberOfRounds(userInput);
    }

    private static Integer createNumberOfRounds(String userInput) {
        return Integer.parseInt(userInput);
    }

    // Output
    public static void printWinnersMessage(Cars cars) {
        System.out.println(OutputView.WinnersMessage(cars));
    }

    public static void printlnCurrentForwardStateMessage(Cars cars) {
        System.out.println(OutputView.currentForwardStateMessage(cars));
    }

    public static void printResultHeaderMessage() {
        System.out.println(OutputView.resultHeaderMessage());
    }
}
