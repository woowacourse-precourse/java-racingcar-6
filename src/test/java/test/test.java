package test;

import java.util.List;
import racingcar.view.GameView;

public class test {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        System.out.print("자동차 입력 : ");
        List<String> carNames = gameView.getCarNames();
        System.out.println(carNames);

        System.out.print("시도할 횟수 입력 : ");
        int round = gameView.getTotalRounds();
        System.out.println("totalround = " + round);
    }
}
