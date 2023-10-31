package racingcar;

import java.util.List;

public class Print {

    private static final RacingGame rg = new RacingGame();
    private static final Util util = new Util();

    public void showResult(List<Car> cars) {
        String dash = "-";
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + util.repeat(dash, car.getMove()));
        }
        System.out.println();
    }

    public void showWinner(List<Car> cars) {
        List<String> winnersName = rg.getMaxMoveCar(cars);
        System.out.println("최종 우승자 : " + util.join(winnersName));
    }
}
