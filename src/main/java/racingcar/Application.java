package racingcar;

import java.util.List;

public class Application {

    private static final Input input = new Input();
    private static final RacingGame rg = new RacingGame();
    private static final Print print = new Print();

    public static void main(String[] args) {

        List<Car> cars = input.getCars();

        int times = input.getTimesToMove();

        rg.race(cars, times);

        print.showWinner(cars);
    }
}
