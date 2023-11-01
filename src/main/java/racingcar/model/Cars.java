package racingcar.model;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.validator.Util.getMax;


public class Cars {
    public final ArrayList<Car> CARS = new ArrayList<>();
    public Cars(ArrayList<String> cars){
        cars.forEach(car->CARS.add(new Car(car)));
    }
    public void play(){
        go();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                .map(Car::getResult)
                .collect(Collectors.toList())
        ));
    }
    public void searchWinner() {
        int maxPosition = getMaxPosition();
        OutputView.printWinner(new ArrayList<>(CARS.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }
    public void go(){
        CARS.forEach(Car::go);
    }

    public int getMaxPosition(){
        CARS.sort(Car::compareTo);
        int maxPosition = CARS.get(0).getPosition();
        return maxPosition;
    }
}
