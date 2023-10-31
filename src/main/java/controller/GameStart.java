package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.InputCheck;
import model.Round;
import view.Input;
import view.Output;

public class GameStart {

    public static void start() {

        String names = Input.name();

        List<String> nameList = InputCheck.name(names);

        String roundStr = Input.round();

        int round = InputCheck.round(roundStr);

        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }

        for (int i = 0; i < round; i++) {
            Round.play(carList);
            Output.roundResult(carList);
        }
    }
}
