package racingcar.service;

import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.util.List;

public class CarService {

    public List<Car> cars;
    public Integer num;

    public void inputGame(){
        OutputView.inputCarMessage();
        cars = InputView.inputCarName();
        OutputView.inputNumMessage();
        num = InputView.inputGameTry();
    }

    public boolean moveRule(){
        return true;
    }
}
