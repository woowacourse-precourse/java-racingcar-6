package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int trials;
    public void getCarNameAndTrials() {
        List<String> carName = List.of(readLine().split(","));
        trials = Integer.parseInt(readLine());
        carName.forEach(name -> cars.add(new Car(name, 0)));
    }

    public void start() {
        IntStream.range(0, trials).forEach(i -> cars.forEach(Car::trial));
    }

    public void printMoves() {
        cars.forEach(Car::printMoves);
    }
}
