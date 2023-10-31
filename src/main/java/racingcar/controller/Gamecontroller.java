package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.PlayerinputView;
import racingcar.view.PlayeroutputView;

import java.util.List;

import static racingcar.view.PlayeroutputView.resultPrize;

public class Gamecontroller {

    public static void start(){
        String[] names = PlayerinputView.getNames();
        List<Car> cars = PlayerinputView.saveNames(names);
        int round = PlayerinputView.getRound();
        gameResult(round, cars);
        int prize = PlayeroutputView.result(cars);
        resultPrize(cars, prize);
    }

    private static void gameResult(int round, List<Car> cars){
        System.out.println("\n실행결과");
        for (int i = 0; i < round; i++) {
            PlayeroutputView.updateRound(cars);
            PlayeroutputView.round(cars);
        }
    }

}
