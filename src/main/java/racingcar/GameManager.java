package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {


    private final Input input;
    private final Output output;
    private List<Car> cars;
    private int count;

    public GameManager() {
        this.input = new Input();
        this.output = new Output();
        this.cars = new ArrayList<Car>();
    }

    public void startGame() {
        obtainCars();
        obtainTime();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            continueGame();
            printNow();
        }
        printWinner();
    }


    private void continueGame() {
        cars.stream().forEach(car -> {
            if (Randoms.pickNumberInRange(Constant.NUMBER_RANGE_INCLUDE, Constant.NUMBER_RANGE_EXCLUDE) >= 4) {
                car.plusCurrentPlace();
            }
        });
    }

    private void obtainCars() {
        output.startOutput();
        input.input();
        String[] carsArray = input.inputCars();
        List<String> stringList = Arrays.stream(carsArray).toList();
        List<Car> carObjects = stringList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars = carObjects;
    }

    private void obtainTime() {
        output.timeOutput();
        input.input();
        count = Integer.parseInt(input.inputTime());
    }

    private void printNow() {
        output.printNow(cars);
    }

    private void printWinner() {
        output.printWinner(cars);
    }


}
