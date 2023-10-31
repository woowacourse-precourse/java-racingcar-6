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
        output.askName();
        makeCars(input);
        output.askTry();

    }

    public void makeCars(InputView input) {
        InputManufacture manufacture = new InputManufacture();
        List<String> nameList = makeCarNames(input, manufacture);
        saveCarList(nameList);
    }

    public ArrayList<String> makeCarNames(InputView input, InputManufacture manufacture) {
        String names = input.readCarNames();
        return manufacture.makeNameList(names);
    }

    public void saveCarList(List<String> nameList) {
        TotalCar totalCar = new TotalCar();

        for (String name : nameList) {
            totalCar.saveNewCar(name);
        }
    }

    public void runGame(InputView input) {

    }

}

class InputView {
    public String readCarNames() {
        String input = Console.readLine();
        runNameValidator(input);
        return input;
    }

    public String readTryNumber() {
        String number = Console.readLine();
        runTryValidator(number);
        return number;
    }

    private void runNameValidator(String input) {
        NameValidation.checkWord(input);
    }

    private void runTryValidator(String input) {
        TryValidation tryValidation = new TryValidation();
        tryValidation.checkTryNumber(input);
    }

}

class OutputView {
    private final static String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String MOVE_DISTANCE = "-";

    public void askName() {
        System.out.println(NAME_MESSAGE);
    }

    public void askTry() {
        System.out.println(TRY_MESSAGE);
    }

    public void showResultNotice() {
        System.out.println(RESULT_MESSAGE);
    }
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

