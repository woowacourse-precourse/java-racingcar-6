package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.validation.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private List<Car> carList;
    private int round;

    public Race(){
        this.carList = new ArrayList<>();
    }

    public void gameStart() {
        carsGenerate();
    }

    public void carsGenerate() {
        OutputView.inputCarNameView();
        String[] carNames = InputView.inputCarName();
        for (var carName : carNames) {
            carAdd(carName);
        }
    }

    public void carAdd(String carName) {
        Validation.carNameSizeCheck(carName);
        carList.add(new Car(carName));
    }

    public void run() {
        gameStart();
    }
}
