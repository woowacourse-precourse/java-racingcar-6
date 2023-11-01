package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Racing {
    private final ArrayList<Car> cars = new ArrayList<>();

    public Racing(ArrayList<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void startLap() {
        drive();
        OutputView.printRoundResult(cars);
    }

    public void drive() {
        cars.forEach(car -> car.drive(NumberGenerator.getNumber()));
    }

    private ArrayList<Integer> getPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        cars.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }

    public static int getMax(ArrayList<Integer> integers) {
        return Collections.max(integers);
    }

    public void showWinners() {
        int max = getMax(getPositions());
        OutputView.printWinner(new ArrayList<>(cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }
}
