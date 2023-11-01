package racingcar.util;

import racingcar.domain.Car;
import racingcar.message.GameMessage;
import racingcar.view.OutputView;

import java.util.List;

public class WinnerCalculator {

    List<Car> cars;

    List<Integer> winnerList;

    public WinnerCalculator(List<Car> cars, List<Integer> winnerList) {
        this.cars = cars;
        this.winnerList = winnerList;
    }

    public String makeWinnerString(List<Integer> winnerNumber){
        String result;
        if (winnerNumber.size() == 1) {
            Car winner = cars.get(winnerNumber.get(0));
            winner.printName();
        } else if (winnerNumber.size() > 1) {
            for (int i = 0; i < winnerNumber.size() - 1; i++) {
                Car winner = cars.get(winnerNumber.get(i));
                winner.printName();
                OutputView.console(GameMessage.INSERT_REST_MULTIPLE_WINNER);
            }
            cars.get(winnerNumber.get(winnerNumber.size()));
        }

        return result;
    }
}
