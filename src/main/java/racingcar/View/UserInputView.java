package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Exception.UserInputException;

public class UserInputView {

    private final UserInputException userInputException = new UserInputException();

    public List<Car> InputCarNames() {
        List<Car> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        List<String> inputList = Arrays.asList(userInput.split(","));
        userInputException.validateCarNameLength(inputList);

        for (String s : inputList) {
            carList.add(new Car(s));
        }

        return carList;
    }
}
