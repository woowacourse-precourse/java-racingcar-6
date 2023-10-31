package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputView read = new InputView();
        OutputView write = new OutputView();

        GameSystem system = new GameSystem();
        system.start(read, write);

    }
}


class GameSystem {
    public void start(InputView read, OutputView write) {

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

}

class TotalCar {

}

class Car {

}

class CarCondition {

}

class Winner {

}

