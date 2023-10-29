package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.Input.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int IterationNumber;
        List<String> carNames = new ArrayList<>();

        carNames = userInput.getCarNames();
        System.out.println(carNames);

        IterationNumber = userInput.getIterationNumber();
        System.out.println(IterationNumber);
    }
}
