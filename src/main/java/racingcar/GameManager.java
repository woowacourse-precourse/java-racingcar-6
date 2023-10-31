package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {


    private Input input;
    private Output output;
    private List<Car> cars;

    private int count;

    public GameManager() {
        this.input = new Input();
        this.output = new Output();
        this.cars = new ArrayList<Car>();
    }

    public void startGame() {
        obtainCars();
        for (int i = 0; i < count; i++) {
            printNow();
        }

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


}
