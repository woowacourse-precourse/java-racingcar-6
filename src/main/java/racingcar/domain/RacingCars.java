package racingcar.domain;

import racingcar.utils.RandomNumber;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars = new ArrayList<>();

    public RacingCars(List<String> carNames){
        for(String carName : carNames){
            racingCars.add(new Car(carName));
        }
    }

    public void moveCars(){
        for(Car car : racingCars){
            car.move(RandomNumber.getRandomNumber());
            OutputView.printCarPositionMessage(car);
        }
    }

}
