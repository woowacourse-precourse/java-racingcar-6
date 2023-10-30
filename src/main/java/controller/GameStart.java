package controller;

import java.util.List;
import model.InputCheck;
import view.Input;

public class GameStart {

    public static void start() {

        String names = Input.name();

        List<String> nameList = InputCheck.name(names);

        String roundStr = Input.round();

        int round = InputCheck.round(roundStr);

        System.out.println(round);

    }
}
