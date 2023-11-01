package racingcar;

import java.util.List;
import racingcar.controller.RacingStartController;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.PrintView;

public class Application {
    private final static PrintView printView = new PrintView();
    private final static RacingStartController startController = new RacingStartController();
    private static void startRound(Racing racing) {
        for (int i = 0; i < racing.getRaceCount(); i++) {
            startController.startMove(racing);
            printView.printFowardCount(racing.getCarList());
        }
    }

    private static void run(String racingCount, List<Car> carList) {
        if(startController.run(racingCount, carList) != null) {
            Racing racing = startController.run(racingCount, carList);
            startRound(racing);
            startController.resultWinnerList(racing);
            printView.printWinner(racing.getWinnerList());
        }
    }
    private static void startRacing() {
        String cars = printView.printStartMessage();
        List<Car> carList = startController.getRacingCarList(cars);
        String racingCount = printView.printCountMessage();
        run(racingCount, carList);
    }
    public static void main(String[] args) {
        startRacing();
    }
}
