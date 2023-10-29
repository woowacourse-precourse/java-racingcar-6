package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.PlayerinputView;

import java.util.List;

public class Gamecontroller {
    private final PlayerinputView playerinputView = new PlayerinputView();
    public static void start(){
        String[] names = PlayerinputView.getNames();
        List<Car> cars = PlayerinputView.saveNames(names);
        int round = PlayerinputView.getRound();
    }
}
