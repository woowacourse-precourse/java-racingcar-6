package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {


    private Input input;
    private Output output;
    private List<Car> cars;
    public GameManager() {
        this.input = new Input();
        this.output = new Output();
        this.cars = new ArrayList<Car>();
    }

    private void obtainCars() {
        output.startOutput();
        String[] carsArray = input.inputCars();
        List<String> stringList = Arrays.stream(carsArray).toList();
        List<Car> carObjects = stringList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars = carObjects;
    }

    private void printNow() {
        output.printNow(cars);
    }

    public void startGame() {
        obtainCars();
        printNow();
    }


}
