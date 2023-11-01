package racingcar.gameContoller;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.UserInput;
import racingcar.domain.Result;

import java.util.List;

public class RacingCar {
    private int leaderDistance;
    private int leftRound;
    private List<Car> carList;

    public RacingCar() {
    }

    public void startGame() {
        CarGenerator carGenerator = new CarGenerator();
        carList = carGenerator.createCarList();
        UserInput userInput = new UserInput();
        leftRound = userInput.setRoundOfGame();
        System.out.println("\n실행 결과");
        while (leftRound > 0) {
            playRound(carList);
            leftRound--;
        }
        Result finalReport = new Result();
        finalReport.decideWinner(carList, leaderDistance);
        finalReport.printWinner();
    }

    public void playRound(List<Car> carList) {
        for (Car car : carList) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            int power = randomNumberGenerator.createRandomNumber();
            if (car.canAccelerate(power)) {
                car.accelerate();
            }
        }
        Result roundReport = new Result();
        roundReport.printRaceResult(carList);
        leaderDistance = roundReport.getLeaderDistance(carList);
    }

}
