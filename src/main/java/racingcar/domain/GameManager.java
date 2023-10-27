package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final InputView inputView = new InputView();

    private final RoundManager roundManager = new RoundManager();

    private List<Car> cars = new ArrayList<>();

    private int attempts;

    private void initRaceCars(){
        List<String> carNames = inputView.getCarNames();
        for(String carName: carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
    }

}
