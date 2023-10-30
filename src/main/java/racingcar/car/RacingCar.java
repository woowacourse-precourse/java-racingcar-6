package racingcar.car;

import racingcar.Util;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingCar {
    private final ArrayList<Car> CarList = new ArrayList<>();

    public RacingCar(ArrayList<String> cars) {

        cars.forEach(car -> CarList.add(new Car(car)));
    }

    public void go(){
        CarList.forEach(Car -> Car.go());
    }

    public void playRound(){
        go();
        Util.printRoundResult(new ArrayList<>(CarList.stream()
                .map(Car -> Car.getRoundResult())
                .collect(Collectors.toList())));
    }

    public ArrayList<Integer> getPositions(){
        ArrayList<Integer> positions = new ArrayList<>();
        CarList.forEach(Car -> positions.add(Car.getPosition()));
        return positions;
    }

    public void showWinner(){
        Util.printWinner(new ArrayList<>(CarList.stream()
                .filter(Car -> Car.getWinner(Util.getMax(getPositions())))
                .map(Car::getName)
                .collect(Collectors.toList())));
    }

}
