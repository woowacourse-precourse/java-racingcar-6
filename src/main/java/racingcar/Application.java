package racingcar;

import Controller.Controller;
import Model.Car;
import View.Mc;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Mc mc = new Mc();
        List<Car> carList = new ArrayList<>();

        Controller gameController = new Controller(mc, carList);
        gameController.gameStart();
    }

}
