package racingcar.controller.checkWinner;

import racingcar.model.Car;

import java.util.List;

public class checkWinnerByMove implements CheckWinner{
    @Override
    public String[] getWinner(List<Car> carList) {

        return new String[0];
    }
}
