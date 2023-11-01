package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {


    private final Input input;
    private final Output output;
    private CarList carList;
    private int rounds;

    public GameManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void startGame() {
        initializeCars();
        initializeRounds();
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            carList.moveCars();
            printCurrentStatus();
        }
        printWinners();
    }


    private void initializeCars() {
        output.startGamePrompt();
        input.input();
        String[] carsArray = input.inputCarNames();
        List<String> carNameList = Arrays.stream(carsArray).toList();
        List<Car> carObjects = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        carList = new CarList(carObjects);
    }

    private void initializeRounds() {
        output.roundsPrompt();
        input.input();
        rounds = Integer.parseInt(input.inputRounds());
    }

    private void printCurrentStatus() {
        output.printNow(carList.getCarList());
    }

    private void printWinners() {
        output.printWinner(carList.getCarList());
    }

}
