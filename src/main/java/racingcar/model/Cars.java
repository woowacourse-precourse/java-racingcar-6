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
    public void roundPlay(){
        go();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                .map(Car::getResult)
                .collect(Collectors.toList())
        ));
    }
    public void searchWinner() {
        OutputView.printWinner(new ArrayList<>(CARS.stream()
                .filter(car -> car.isWinner(getMax(getPositions())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    public void go(){
        CARS.forEach(Car::go);
    }

    private ArrayList<Integer> getPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        CARS.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}
