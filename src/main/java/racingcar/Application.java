package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
//        InputView inputView = new InputView();
//        String[] a = inputView.name().split(",");
//        System.out.println(inputView.attemptsNum());
//        System.out.println(Arrays.toString(a));
    }
}
