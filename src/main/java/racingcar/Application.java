package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        GameSystem system = new GameSystem();
        system.start(input, output);

    }
}


class GameSystem {
    public void start(InputView input, OutputView output) {

    }


}

class InputView {
    public String readCarNames() {
        String input = Console.readLine();
        runNameValidator(input);
        return input;
    }

    private void runNameValidator(String input) {
        NameValidation.checkWord(input);
    }

}

class OutputView {

}

class NameValidation {
    public static void checkWord(String input) {
        if (!input.matches("^([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*$")) {
            throw new IllegalArgumentException();
        }
    }
}

class TryValidation {

}

class InputManufacture {
    public ArrayList<String> makeNameList(String data) {
        String[] splitData = data.split(",");
        return new ArrayList<>(Arrays.asList(splitData));
    }
}

class TotalCar {

}

class Car {

}

class CarCondition {

}

class Winner {

}

