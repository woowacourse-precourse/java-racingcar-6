package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class CarRacing {

    List<String> cars;
    List<Integer> carPos;
    RandomUtil randomUtil;

    public CarRacing(List<String> cars, RandomUtil randomUtil) {
        this.cars = cars;
        this.carPos = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carPos.add(0);
        }
        this.randomUtil = randomUtil;
    }

    public void race(int turn) {
        OutputView.printProgressStmt();

        while (turn-- > 0) {
            oneTurnRace();

            OutputView.printOneTurnResult(cars, carPos);
        }

        getRaceResult();
    }

    private void oneTurnRace() {
        for (int i = 0; i < cars.size(); i++) {
            if (randomUtil.generate(0, 9) >= 4) {
                carPos.set(i, carPos.get(i) + 1);
            }
        }
    }

    private void getRaceResult() {
        Referee referee = new Referee();
        List<String> winner = referee.findWinner(cars, carPos);

        OutputView.printWinnerResult(winner);
    }
}
