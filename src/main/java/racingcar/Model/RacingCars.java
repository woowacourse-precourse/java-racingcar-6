package racingcar.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import racingcar.View.OutputView;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();
    public RacingCars(ArrayList<String> carNames) {
        carNames.forEach(car -> CARS.add(new Car(car)));
    }

//    public void showWinners(){
//        OutputView.printWinner(new ArrayList<>(CARS.stream())
//                .filter(car -> car.isWinner(Collections.max(getPosition())))
//                .map(Car::getName))
//                .collect(Collectors.toList());
//    }

    private void go(){
        CARS.forEach(Car::go);
    }
}
