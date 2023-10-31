package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = View.initGameView();
        List<Car> cars = Controller.inputToCarList(input);

        Integer cycle = View.getCycleView();

        for (int i = 0; i < cycle; i++) {
            Controller.isForward(cars);
            View.resultView(i, cars);
        }

        View.winnerView(Controller.findWinner(cars));
    }
}
