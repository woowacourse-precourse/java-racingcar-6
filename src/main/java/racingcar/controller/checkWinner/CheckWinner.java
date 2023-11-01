package racingcar.controller.checkWinner;

import racingcar.model.Car;

import java.util.List;

public interface CheckWinner {
    public String[] getWinner(List<Car> carList);
}
