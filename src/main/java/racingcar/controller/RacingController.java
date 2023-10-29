package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    List<String> racingCarsList = new ArrayList<>();
    Car car = new Car();

    public void GameProgress() {

    }

    public void InputCarsByUser() {
        InputView.inputCars();
        String inputCars = Console.readLine();
        racingCarsList = List.of(inputCars.split(","));
    }

    public void InputAttemptsByUser() {
        InputView.inputAttemptsNum();
        int inputAttempts = Integer.parseInt(Console.readLine());
    }

    public int CreateRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void IsMoreThan() {
        if (CreateRandomNum() >= 4) {
            car.move();
        }
    }
}
