package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    RacingCars racingCars;
    Exception exception = new Exception();

    int attempts = 0;
    int maxPosition = 0;
    public static final String PRINT_COMMA = ",";

    List<String> carNames = new ArrayList<>();
    List<String> winners = new ArrayList<>();

    public void GameProgress() {
        InputCarsByUser();
        InputAttemptsByUser();

        OutputView.printResult();
        for (int i = 0; i < attempts; i++) {
            PrintRacingCar();
            System.out.println();
        }

        PrintWinners();
    }

    public void InputCarsByUser() {
        InputView.inputCars();
        String inputCars = Console.readLine();
        carNames = List.of(inputCars.split(PRINT_COMMA));
        exception.CarNameException(carNames);

        racingCars = new RacingCars(carNames);
    }

    public void InputAttemptsByUser() {
        InputView.inputAttemptsNum();
        attempts = Integer.parseInt(Console.readLine());
    }

    public void PrintRacingCar() {
        racingCars.MoveCars();

        for (Car car : racingCars.GetRacingCars()) {
            System.out.print(car.GetName());
            OutputView.printColon();

            for (int i = 0; i < car.GetPosition(); i++) {
                OutputView.printHyphen();
            }
            System.out.println();
        }
    }

    public void PrintWinners() {
        FindMaxPosition();
        JudgeWinners();

        OutputView.printWinners();
        System.out.println(String.join(PRINT_COMMA + " ", winners));
    }

    public void FindMaxPosition() {
        for (Car car : racingCars.GetRacingCars()) {
            if (maxPosition < car.GetPosition()) {
                maxPosition = car.GetPosition();
            }
        }
    }

    public void JudgeWinners() {
        for (Car car : racingCars.GetRacingCars()) {
            if (car.GetPosition() == maxPosition) {
                winners.add(car.GetName());
            }
        }
    }
}
