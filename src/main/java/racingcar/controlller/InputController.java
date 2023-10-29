package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.utils.Parser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class InputController {
    public static Cars scanCars() {
        System.out.println(InputView.enterCarNamesMessage());
        String userInput = Console.readLine();
        InputValidator.validateCarList(userInput);

        return createCars(userInput);
    }

    private static Cars createCars(String userInput) {
        List<Car> carList = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new Cars(carList);
    }

    public static Round scanRound() {
        System.out.println(InputView.enterNumberOfRoundsMessage());
        String userInput = Console.readLine();
        InputValidator.validateNumberOfRounds(userInput);

        return createRound(userInput);
    }

    private static Round createRound(String userInput) {
        return new Round(Integer.parseInt(userInput));
    }
}
