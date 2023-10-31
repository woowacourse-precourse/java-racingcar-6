package racingcar;

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


}

class OutputView {

}

class NameValidation {
    public void checkWord(String input) {
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

