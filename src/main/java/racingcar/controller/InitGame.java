package racingcar.controller;


import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.view.OutputString;

public class InitGame {
    private final ArrayList<Car> classList;
    private final int count;

    public InitGame() {
        OutputString.printGuessName();

        CarListController carList = new CarListController();
        classList = carList.getClassList();

        OutputString.printGuessCount();

        InputCount inputCount = new InputCount();
        count = inputCount.getCount();

        System.out.println();
    }

    public ArrayList<Car> getClassList() {
        return classList;
    }

    public int getCount() {
        return count;
    }

}
