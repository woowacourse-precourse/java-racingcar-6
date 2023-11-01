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

    public String makeWinnerString(){
        String result = GameMessage.INSERT_GAME_RESULT_MESSAGE;
        int winnerSize = winnerList.size();
        if (this.winnerList.size() == 1) {
            return GameMessage.INSERT_GAME_RESULT_MESSAGE + cars.get(winnerList.get(0)).getName();


        } else if (this.winnerList.size() > 1) {

            for (int i = 0; i < winnerSize - 1; i++) {  //4
                result += cars.get(winnerList.get(i)).getAnswer();
            }
            result += cars.get(winnerList.get(winnerSize-1)).getName();
            return result;

        }
        return result;
    }
}
