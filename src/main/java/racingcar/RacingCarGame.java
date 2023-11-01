package racingcar;

import java.util.List;

public class RacingCarGame {
    public List<String> carName;
    public List<Integer> movementSoFar;
    RacingCar racingCar = new RacingCar();

    public RacingCarGame() {
        racingCar.carName();
        racingCar.setMovement();
        racingCar.numberOfTries();
        this.carName = racingCar.carName;
        this.movementSoFar = racingCar.movementSoFar;
    }

    public void playRacingCar() {
        racingCar.printResultText();
        for (int i = 0; i < racingCar.numberOfTries; i++) {
            for (int j = 0; j < racingCar.carName.size(); j++) {
                System.out.println(racingCar.printMovement(j, carName));
            }
            racingCar.changeLine();
        }
        System.out.println(racingCar.printFinalWinner(movementSoFar, carName));
    }
}