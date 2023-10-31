package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        makeCars(input);


    }

    public void makeCars(InputView input) {
        InputManufacture manufacture = new InputManufacture();
        List<String> nameList = makeCarNames(input, manufacture);
        TotalCar totalCar = new TotalCar();
        

    }

    public ArrayList<String> makeCarNames(InputView input, InputManufacture manufacture) {
        String names = input.readCarNames();
        return manufacture.makeNameList(names);
    }

}

class InputView {
    public String readCarNames() {
        String input = Console.readLine();
        runNameValidator(input);
        return input;
    }

    public String readTryNumber(TryValidation tryValidation) {
        String number = Console.readLine();
        runTryValidator(number, tryValidation);
        return number;
    }

    private void runNameValidator(String input) {
        NameValidation.checkWord(input);
    }

    private void runTryValidator(String input, TryValidation tryValidation) {
        tryValidation.checkTryNumber(input);
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
    public void checkTryNumber(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

}

class InputManufacture {
    public ArrayList<String> makeNameList(String data) {
        String[] splitData = data.split(",");
        return new ArrayList<>(Arrays.asList(splitData));
    }
}

class TotalCar {
    private List<Car> carList = new ArrayList<>();

    public void saveNewCar(String name) {
        Car car = new Car(name);
        carList.add(car);
    }


}


class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }


}

class CarCondition {

}

class Winner {

}

