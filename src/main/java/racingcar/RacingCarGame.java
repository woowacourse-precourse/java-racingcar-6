package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    public List<String> carName = new ArrayList<String>();
    public List<Integer> movementSoFar = new ArrayList<Integer>();
    RacingCar racingCar = new RacingCar();

    public RacingCarGame() {
        this.carName = racingCar.carName;
        this.movementSoFar = racingCar.movementSoFar;
    }

    public void playRacingCar() {
        System.out.printf("%n실행결과%n");
        for (int i = 0; i < racingCar.numberOfTries; i++) {
            for (int j = 0; j < racingCar.carName.size(); j++) {
                racingCar.updateMovement(j);
                racingCar.getDash(j);
                racingCar.printMovement(j);
            }
            racingCar.changeLine();
        }
        int longestMovement = racingCar.longestMovement(movementSoFar);
        List<Integer> winnerIndexList = racingCar.howManyWinners(longestMovement);
        racingCar.printFinalWinner(winnerIndexList);
    }
}