package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {


    private final Input input;
    private final Output output;
    private CarList carList;
    private int count;

    public GameManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void startGame() {
        obtainCars();
        obtainTime();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            carList.continueGame();
            printNow();
        }
        printWinner();
    }


    private void obtainCars() {
        output.startOutput();
        input.input();
        String[] carsArray = input.inputCars();
        List<String> stringList = Arrays.stream(carsArray).toList();
        List<Car> carObjects = stringList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        carList = new CarList(carObjects);
    }

    private void obtainTime() {
        output.timeOutput();
        input.input();
        count = Integer.parseInt(input.inputTime());
    }

    private void printNow() {
        output.printNow(carList.getCars());
    }

    private void printWinner() {
        output.printWinner(carList.getCars());
    }

}
