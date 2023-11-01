package racingcar.model;

import racingcar.view.OutputView;
import static racingcar.util.Util.getMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();

    public RacingCars(ArrayList<String> cars){
        cars.forEach(car->CARS.add(new Car(car)));
    }

    public void roundGo(){
        for(Car car:CARS){
            car.go();
        }
    }

    public void playRound() {
        go();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                .map(Car::getRoundResult)
                .collect(Collectors.toList())
        ));
    }
    private void go() {
        CARS.forEach(Car::go);
    }

    public void getWinners(){
        OutputView.printWinner(new ArrayList<>(CARS.stream()
                .filter(car -> car.isWinner(getMax(getPositions())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    public ArrayList<Integer> getPositions(){
        ArrayList<Integer> positons = new ArrayList<>();
        CARS.forEach(car -> positons.add(car.getPosition()));
        return positons;
    }

    public static int findMax(ArrayList<Integer> positions){
        return Collections.max(positions);
    }

}
