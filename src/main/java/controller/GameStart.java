package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.InputCheck;
import view.Input;

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


    }
}
