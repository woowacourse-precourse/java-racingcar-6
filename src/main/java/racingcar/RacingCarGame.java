package racingcar;

import racingcar.CarList;

import java.io.PrintStream;

import static racingcar.CommandLine.showln;

public class RacingCarGame {

    private CarList carList;
    private int numberOfAttempts;
    private MoveForwardConditioner moveForwardConditioner;


    public void setup(
            MoveForwardConditioner moveForwardConditioner,
            InputArgumentsHandler inputArgumentsHandler
    ) {
        this.carList = new CarList(inputArgumentsHandler.inputCars());
        this.numberOfAttempts = inputArgumentsHandler.inputRoundNumbers();
        this.moveForwardConditioner = moveForwardConditioner;
    }

    public void play() {
        showln("");
        showln("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            carList.playRound(moveForwardConditioner);
        }
    }

    public void showAwards() {
        showln("최종 우승자 : " + carList.winningCars());
    }
}
