package racingcar.user;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.game.Referee;
import racingcar.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    private List<String> carNames = new ArrayList<>();
    private int attemptCount;

    Validation validation = new Validation();

    private String input() {
        String input = validation.nullStringInput(Console.readLine().trim());
        return input;
    }

    public List<String> carNames() {
        String input = input();
        String[] arr = input.split(",");
        carNames = Arrays.asList(arr);
        return validation.carNameInputValidation(carNames);
    }

    public int attemptCountInput() {
        String input = input();
        return Integer.parseInt(input);
    }

    public void startRace() {
        List<String> carNames = this.carNames;
        int tryCount = this.attemptCount;

        // car 객체 저장
        List<Car> cars = new ArrayList<>();

        // Car 객체 생성
        for(String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

    }

}
