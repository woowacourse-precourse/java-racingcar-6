package racingcar.business;

import racingcar.ui.InputView;
import racingcar.ui.Output;
import racingcar.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberMaker numberMaker = new NumberMaker();

    List<Car> carList;

    public void doRacing() {
        outputView.print(Output.GET_NAMES);
        List<String> names = inputView.getNames();

        outputView.print(Output.GET_GAME_COUNT);
        Integer gameCount = inputView.getGameCount();

        System.out.println("gameCount = " + gameCount);
        System.out.println("names = " + names);

        carList = getCars(names);
    }

    private void tryMoving(Car car) {
        int randomNumber = numberMaker.getRandomNumber();
        car.moveCar(randomNumber);
        outputView.printMoveResult(car);
    }

    private static List<Car> getCars(List<String> names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
