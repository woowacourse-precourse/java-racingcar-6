package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<Car> getCarList() {
        OutputView.printCarNameText();
        List<String> carNames = splitInputByComma(Console.readLine());
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }
    public List<String> splitInputByComma(String input) {
        String[] splitInputArray = input.split(",");
        return trimInputOneByOne(splitInputArray);
    }

    private List<String> trimInputOneByOne(String[] inputList) {
        List<String> trimInputList = new ArrayList<>();
        for (String input : inputList) {
            trimInputList.add(input.trim());
        }
        return trimInputList;
    }

    public void closeConsole() {
        Console.close();
    }
}
