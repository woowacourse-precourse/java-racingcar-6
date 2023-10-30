package racingcar.business;

import racingcar.ui.InputView;
import racingcar.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    InputView inputView = new InputView();

    List<Car> carList;

    public void doRacing() {
        Output.GET_NAMES.print();
        List<String> names = inputView.getNames();

        Output.GET_GAME_COUNT.print();
        Integer gameCount = inputView.getGameCount();

        System.out.println("gameCount = " + gameCount);
        System.out.println("names = " + names);

        carList = getCars(names);
    }

    private static List<Car> getCars(List<String> names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
