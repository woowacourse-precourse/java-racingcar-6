package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars =  cars;
    }

    public void showResult() {
        OutputView.printResult(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
