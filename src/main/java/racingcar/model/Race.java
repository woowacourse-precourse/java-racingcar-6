package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int round;
    private String winner;

    public Race() {
        cars = new ArrayList<>();
    }

    public void setCarNames(String inputString) {
        String[] splitInput = inputString.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(splitInput));
        for (String carName : carNames) {
            // carName에 대한 예외 검사
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }

    public void setRound(String inputString) {
        // inputString에 대한 검사
        round = Integer.parseInt(inputString);
    }
}
