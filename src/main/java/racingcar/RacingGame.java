package racingcar;

import java.util.List;

public class RacingGame {
    private final int rangeStart = 0;
    private final int ragneEnd = 9;
    private final int limitNumber = 4;
    private int attemptCount;
    private UserInput userInput;
    private CarManagement carmanagement;

    public RacingGame() {
        this.userInput = new UserInput();
        this.carmanagement = new CarManagement();
    }

    public RacingGame(UserInput userInput, CarManagement carmanagement) {
        this.userInput = userInput;
        this.carmanagement = carmanagement;
    }

    public void setting() {
        List<String> carList = this.userInput.getCarList();
        for (String car : carList) {
            this.carmanagement.addCar(car);
        }
        this.attemptCount = this.userInput.getAttemptNumber();
    }

    public void play() {
        System.out.println();
        System.out.println("실행 결과");
        for (; this.attemptCount > 0; this.attemptCount--) {
            this.carmanagement.playRound(rangeStart, ragneEnd, limitNumber);
        }
    }

    public void run() {
        setting();
        play();
        this.carmanagement.printWinner();
    }
}
