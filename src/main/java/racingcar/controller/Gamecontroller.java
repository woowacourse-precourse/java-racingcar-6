package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.PlayerinputView;
import racingcar.view.PlayeroutputView;

import java.util.List;

import static racingcar.view.PlayeroutputView.resultPrize;

public class Gamecontroller {
    private final PlayerinputView playerinputView = new PlayerinputView();
    public static void start(){
        String[] names = PlayerinputView.getNames();
        List<Car> cars = PlayerinputView.saveNames(names);
        int round = PlayerinputView.getRound();
        gameResult(round, cars);
        int prize = PlayeroutputView.result(cars);
        gamePrize(cars, prize);
    }

    private static void gameResult(int round, List<Car> cars){
        System.out.println("\n실행결과");
        for (int i = 0; i < round; i++) {
            PlayeroutputView.updateRound(cars);
            PlayeroutputView.round(cars);
        }
    }

    private static void gamePrize(List<Car> cars, int prize) {
        System.out.print("최종 우승자 : ");
        resultPrize(cars, prize);
    }

}
