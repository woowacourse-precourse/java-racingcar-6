package racingcar.gameContoller;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.UserInput;
import racingcar.domain.Result;

import java.util.List;

public class RacingCar {
    int leftRound;
    List<Car> carList;

    public RacingCar() {
    }

    public void startGame() {
        carList = CarGenerator.createCarList();
        leftRound = UserInput.setRoundOfGame();
        System.out.println("실행 결과");
        while (leftRound > 0) {
            playRound(carList);
            leftRound--;
        }
    }

    public void playRound(List<Car> carList) {
        for (Car car : carList) {
            int power = RandomNumberGenerator.createRandomNumber();
            if (car.canAccelerate(power)) {
                car.accelerate();
            }
        }
        Result roundReport = new Result();
        roundReport.printRaceResult(carList);
        leaderDistance = roundReport.getLeaderDistance(carList);
    }

}
