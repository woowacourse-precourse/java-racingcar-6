package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final int MOVE_FORWARD_NUMBER = 4;
    private final RacingCars racingCars;
    private int numberOfRounds;

    public RaceController(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void startRace() {
        this.numberOfRounds = getNumberOfRounds(InputView.howManyTries());
        race(this.racingCars);
    }

    private void race(RacingCars racingCars) {
        System.out.println(OutputView.resultText());
        while(numberOfRounds-- > 0) {
            round(racingCars.getRacingCars());
            System.out.print(showRacingStatus(racingCars));
        }
    }

    private String showRacingStatus(RacingCars racingCars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars.getRacingCars()) {
            sb.append(showCarStatus(car)).append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String showCarStatus(Car car) {
        return car.getName() + " : " + OutputView.showMoveStatus(car.getMove());
      }

    private int getNumberOfRounds(String input) {
        return Integer.parseInt(input);
    }

    private void round(List<Car> racingCars) {
        for(Car car : racingCars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        int forwardCheck = generateRandomNumber();
        if(forwardCheck >= MOVE_FORWARD_NUMBER) {
            car.moveForward();
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
