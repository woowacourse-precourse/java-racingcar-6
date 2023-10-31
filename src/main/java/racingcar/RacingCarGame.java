package racingcar;

import java.util.List;

public class RacingCarGame {
    public List<String> carName;
    public List<Integer> movementSoFar;
    RacingCar racingCar = new RacingCar();

    public RacingCarGame() {
        this.carName = racingCar.carName;
        this.movementSoFar = racingCar.movementSoFar;
    }

    public void playRacingCar() {
        racingCar.printResultText();
        for (int i = 0; i < racingCar.numberOfTries; i++) {
            for (int j = 0; j < racingCar.carName.size(); j++) {
                racingCar.printMovement(j);
            }
            racingCar.changeLine();
        }
        racingCar.printFinalWinner(movementSoFar);
    }
}